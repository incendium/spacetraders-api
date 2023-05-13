package com.iamincendium.spacetraders.api.error

/**
 * An error indicating that a protected API call was invoked when no API token was provided.
 */
public object MissingTokenError : APIError {
    override val message: String = "Invoked endpoint requires API token but no token was provided."
}
