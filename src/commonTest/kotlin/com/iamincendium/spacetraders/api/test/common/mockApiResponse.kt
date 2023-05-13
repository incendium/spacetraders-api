package com.iamincendium.spacetraders.api.test.common

import com.iamincendium.spacetraders.api.client.internal.defaultHttpClient
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*

fun mockApiResponse(
    expectedUrl: String,
    response: String,
    status: HttpStatusCode = HttpStatusCode.OK,
    headers: Headers = headersOf(HttpHeaders.ContentType, "application/json"),
): HttpClient {
    val mockEngine = MockEngine { request ->
        when (val url = request.url.toString()) {
            expectedUrl -> respond(
                content = response,
                status = status,
                headers = headers,
            )
            else -> throw MockResponseException(url, expectedUrl)
        }
    }

    return defaultHttpClient(mockEngine)
}
