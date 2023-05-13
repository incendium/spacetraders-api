package com.iamincendium.spacetraders.api.error

/**
 * An unexpected "exceptional" error has occurred.
 */
public data class UnexpectedError(val cause: Throwable) : APIError {
    override val message: String = cause.message ?: "No message provided."
}
