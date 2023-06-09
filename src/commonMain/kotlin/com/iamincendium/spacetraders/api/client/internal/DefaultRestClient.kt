@file:Suppress("UNUSED_VARIABLE")
package com.iamincendium.spacetraders.api.client.internal

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.iamincendium.spacetraders.api.error.APIError
import com.iamincendium.spacetraders.api.error.APIErrorCode
import com.iamincendium.spacetraders.api.error.AccountError
import com.iamincendium.spacetraders.api.error.ContractError
import com.iamincendium.spacetraders.api.error.GenericHTTPError
import com.iamincendium.spacetraders.api.error.GenericServerError
import com.iamincendium.spacetraders.api.error.MarketError
import com.iamincendium.spacetraders.api.error.ShipError
import com.iamincendium.spacetraders.api.models.ErrorResponse
import com.iamincendium.spacetraders.api.result.APIResult
import com.iamincendium.spacetraders.api.util.runOrErrorAndFlatten
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.delay
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
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

            contentType(ContentType.Application.Json)
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
        codeToError(response.status, response.body<ErrorResponse>().error)
    } catch (ex: NoTransformationFoundException) {
        @Suppress("MaxLineLength")
        LOG.debug(ex) { "Could not find serializer for error response; it is probably not an API error. Falling back to generic error." }

        val status = response.status
        GenericHTTPError(status, status.description)
    }

    private fun codeToError(
        statusCode: HttpStatusCode,
        error: ErrorResponse.Error,
    ): APIError = when (val errorCode = APIErrorCode(error.code)) {
        is APIErrorCode.Account -> AccountError(statusCode, error.message, errorCode, error.data)
        is APIErrorCode.Contract -> ContractError(statusCode, error.message, errorCode, error.data)
        is APIErrorCode.Market -> MarketError(statusCode, error.message, errorCode, error.data)
        is APIErrorCode.Ship -> ShipError(statusCode, error.message, errorCode, error.data)
        else -> GenericServerError(statusCode, error.message, errorCode, error.data)
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
