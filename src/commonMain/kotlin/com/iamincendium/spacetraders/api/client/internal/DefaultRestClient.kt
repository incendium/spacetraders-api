@file:Suppress("UNUSED_VARIABLE")
package com.iamincendium.spacetraders.api.client.internal

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.iamincendium.spacetraders.api.error.APIError
import com.iamincendium.spacetraders.api.error.GenericHTTPError
import com.iamincendium.spacetraders.api.error.GenericServerError
import com.iamincendium.spacetraders.api.result.APIResult
import com.iamincendium.spacetraders.api.util.runOrErrorAndFlatten
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.delay
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import mu.KotlinLogging

private const val DEFAULT_RATE_LIMIT_PER_SECOND = 2
private const val DEFAULT_BURST_LIMIT = 10
private const val DEFAULT_BURST_DURATION = 10

internal class DefaultRestClient(
    private val apiToken: String?,
    private val baseUrl: String,
    private val httpClient: HttpClient,
) : RestClient {
    private var rateLimitState = RateLimitState()

    override fun hasToken(): Boolean = apiToken != null

    private suspend inline fun request(
        path: String,
        method: HttpMethod,
        builder: HttpRequestBuilder.() -> Unit,
    ): APIResult<HttpResponse> = runOrErrorAndFlatten {
        rateLimitState.waitUntilReady()

        val response: HttpResponse = httpClient.request(baseUrl + path) {
            this.method = method

            if (apiToken != null) {
                header(HttpHeaders.Authorization, "Bearer $apiToken")
            }

            builder()

            if (body !is MultiPartFormDataContent) {
                contentType(ContentType.Application.Json)
            }
        }

        updateRateLimitState(response.headers)

        if (response.status.isSuccess()) {
            Ok(response)
        } else {
            Err(mapFailureToError(response))
        }
    }

    private fun updateRateLimitState(headers: Headers) {
        val type = headers["X-RateLimit-Type"]
        val limit = headers["X-RateLimit-Limit"]?.toInt() ?: DEFAULT_RATE_LIMIT_PER_SECOND
        val remaining = headers["X-RateLimit-Remaining"]?.toInt() ?: DEFAULT_RATE_LIMIT_PER_SECOND
        val resetTime = headers["X-RateLimit-Reset"]?.let { Instant.parse(it) } ?: Clock.System.now()
        val limitBurst = headers["X-RateLimit-Limit-Burst"]?.toInt() ?: DEFAULT_BURST_LIMIT
        val limitPerSecond = headers["X-RateLimit-Limit-Per-Second"]?.toInt() ?: DEFAULT_RATE_LIMIT_PER_SECOND

        rateLimitState = RateLimitState(limit, remaining, resetTime)
    }

    private suspend fun mapFailureToError(response: HttpResponse): APIError = try {
        val jsonObject = response.body<JsonObject>()
        val code = jsonObject["code"]?.jsonPrimitive?.intOrNull
        val message = jsonObject["message"]?.toString()
        val data = jsonObject["data"]?.jsonObject

        val status = response.status
        if (code != null && message != null) {
            codeToError(status, code, message, data ?: JsonObject(emptyMap()))
        } else {
            GenericHTTPError(status, message ?: status.description)
        }
    } catch (ex: NoTransformationFoundException) {
        @Suppress("MaxLineLength")
        LOG.debug(ex) { "Could not find serializer for error response; it is probably not an API error. Falling back to generic error." }

        val status = response.status
        GenericHTTPError(status, status.description)
    }

    // TODO: Remove suppression once custom cases are actually added.
    @Suppress("UNUSED_EXPRESSION")
    private fun codeToError(
        statusCode: HttpStatusCode,
        code: Int,
        message: String,
        data: JsonObject,
    ): APIError = when (code) {
        else -> GenericServerError(statusCode, message, code, data)
    }

    override suspend fun get(path: String, builder: HttpRequestBuilder.() -> Unit): APIResult<HttpResponse> =
        request(path, HttpMethod.Get, builder)

    override suspend fun post(path: String, builder: HttpRequestBuilder.() -> Unit): APIResult<HttpResponse> =
        request(path, HttpMethod.Post, builder)

    override suspend fun patch(path: String, builder: HttpRequestBuilder.() -> Unit): APIResult<HttpResponse> =
        request(path, HttpMethod.Patch, builder)

    private companion object {
        private val LOG = KotlinLogging.logger {}
    }
}

private data class RateLimitState(
    val limit: Int = DEFAULT_RATE_LIMIT_PER_SECOND,
    val remaining: Int = DEFAULT_RATE_LIMIT_PER_SECOND,
    val resetTime: Instant = Clock.System.now(),
)

private suspend fun RateLimitState.waitUntilReady() {
    if (remaining > 0) return

    val waitDuration = resetTime.minus(Clock.System.now())
    if (waitDuration.isPositive()) delay(waitDuration)
}
