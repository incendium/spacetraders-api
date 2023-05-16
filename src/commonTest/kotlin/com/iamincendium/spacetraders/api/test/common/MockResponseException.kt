package com.iamincendium.spacetraders.api.test.common

import io.ktor.http.*

class MockResponseException(method: HttpMethod, url: String, expectedMethod: HttpMethod, expectedUrl: String) :
    Exception("Expected $expectedMethod request at $expectedUrl; Got $method request at $url instead.")
