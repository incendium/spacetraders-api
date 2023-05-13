package com.iamincendium.spacetraders.api.error

/**
 * An exception wrapping around an [APIError] instance.
 */
public class APIException(public val error: APIError) : Exception(error.message)
