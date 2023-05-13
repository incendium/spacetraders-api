package com.iamincendium.spacetraders.api.client.internal

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.iamincendium.spacetraders.api.result.APIResult
import com.iamincendium.spacetraders.api.error.APIError
import com.iamincendium.spacetraders.api.util.runOrErrorAndFlatten
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.delay
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

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

    private fun mapFailureToError(response: HttpResponse): APIError {
        TODO()
    }

    override suspend fun get(path: String, builder: HttpRequestBuilder.() -> Unit): APIResult<HttpResponse> =
        request(path, HttpMethod.Get, builder)

    override suspend fun post(path: String, builder: HttpRequestBuilder.() -> Unit): APIResult<HttpResponse> =
        request(path, HttpMethod.Post, builder)

    override suspend fun patch(path: String, builder: HttpRequestBuilder.() -> Unit): APIResult<HttpResponse> =
        request(path, HttpMethod.Patch, builder)
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
