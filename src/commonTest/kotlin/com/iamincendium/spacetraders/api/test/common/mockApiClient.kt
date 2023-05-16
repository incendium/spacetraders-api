package com.iamincendium.spacetraders.api.test.common

import com.iamincendium.spacetraders.api.SpaceTradersClient
import io.ktor.http.*

/**
 * Construct a new API client backed by a mock HTTP client instance.
 *
 * @param expectedPath the path element to mock (this is appended to the [baseUrl])
 * @param response the response to send back to the client
 * @param status the HTTP status code to send back to the client
 * @param headers a collection of headers to send back to the client
 * @param apiToken the API token to test with (this *should not* be a valid API token)
 * @param baseUrl the base URL to mock
 */
@Suppress("LongParameterList")
fun mockApiClient(
    expectedMethod: HttpMethod,
    expectedPath: String,
    response: String,
    status: HttpStatusCode = HttpStatusCode.OK,
    headers: Headers = headersOf(HttpHeaders.ContentType, "application/json"),
    apiToken: String? = "dummy-token",
    baseUrl: String = SpaceTradersClient.BASE_URL,
): SpaceTradersClient = SpaceTradersClient(
    apiToken,
    baseUrl,
    mockApiResponse(expectedMethod, "$baseUrl$expectedPath", response, status, headers),
)
