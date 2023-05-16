package com.iamincendium.spacetraders.api.test.common

import com.iamincendium.spacetraders.api.client.internal.defaultHttpClient
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*

fun mockApiResponse(
    expectedMethod: HttpMethod,
    expectedUrl: String,
    response: String,
    status: HttpStatusCode = HttpStatusCode.OK,
    headers: Headers = headersOf(HttpHeaders.ContentType, "application/json"),
): HttpClient {
    val mockEngine = MockEngine { request ->
        val url = request.url.toString()
        val method = request.method

        when {
            url == expectedUrl && method == expectedMethod -> respond(
                content = response,
                status = status,
                headers = headers,
            )
            else -> throw MockResponseException(method, url, expectedMethod, expectedUrl)
        }
    }

    return defaultHttpClient(mockEngine, LogLevel.ALL)
}
