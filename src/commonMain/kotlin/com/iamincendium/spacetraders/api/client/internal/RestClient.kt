package com.iamincendium.spacetraders.api.client.internal

import com.github.michaelbull.result.Err
import com.iamincendium.spacetraders.api.result.APIResult
import com.iamincendium.spacetraders.api.error.MissingTokenError
import com.iamincendium.spacetraders.api.util.runOrErrorAndFlatten
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

internal interface RestClient {
    fun hasToken(): Boolean

    suspend fun get(path: String, builder: HttpRequestBuilder.() -> Unit = {}): APIResult<HttpResponse>
    suspend fun post(path: String, builder: HttpRequestBuilder.() -> Unit = {}): APIResult<HttpResponse>
    suspend fun patch(path: String, builder: HttpRequestBuilder.() -> Unit = {}): APIResult<HttpResponse>
}

internal fun RestClient(apiToken: String?, baseUrl: String, httpClient: HttpClient): RestClient =
    DefaultRestClient(apiToken, baseUrl, httpClient)

/**
 * Run a block of code which requires a valid API token and returns an [APIResult]. If there is no token available,
 * return an error indicating that no token is available.
 */
internal inline fun <T : Any> RestClient.runRequiringToken(block: () -> APIResult<T>) = runOrErrorAndFlatten {
    if (hasToken()) {
        block()
    } else {
        Err(MissingTokenError)
    }
}
