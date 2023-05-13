package com.iamincendium.spacetraders.api.error

/**
 * Denotes an error that occurred while interacting with the API.
 */
public sealed interface APIError {
    public val message: String
}
