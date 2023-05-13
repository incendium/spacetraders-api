package com.iamincendium.spacetraders.api.result

import com.github.michaelbull.result.Result
import com.github.michaelbull.result.getOrThrow
import com.github.michaelbull.result.mapError
import com.iamincendium.spacetraders.api.error.APIException
import com.iamincendium.spacetraders.api.error.UnexpectedError

/**
 * Variant of [getOrThrow] which rethrows the original exception if an error was caused by an exception, otherwise
 * throws an [APIException] wrapping the non-exceptional error.
 */
public fun <T : Any> APIResult<T>.getOrRethrow(): T = mapErrorAsThrowable().getOrThrow()

/**
 * Re-map the underlying error as an exception if it was not caused by an exception, otherwise re-map to the original
 * exception.
 */
public fun <T : Any> APIResult<T>.mapErrorAsThrowable(): Result<T, Throwable> = mapError {
    when (it) {
        is UnexpectedError -> it.cause
        else -> APIException(it)
    }
}
