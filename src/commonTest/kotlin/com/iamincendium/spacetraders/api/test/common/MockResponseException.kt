package com.iamincendium.spacetraders.api.test.common

class MockResponseException(url: String, expectedUrl: String) :
    Exception("Expected request at $expectedUrl; Got request at $url instead.")
