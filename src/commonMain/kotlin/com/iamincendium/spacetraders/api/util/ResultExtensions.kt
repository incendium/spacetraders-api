package com.iamincendium.spacetraders.api.util

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.mapError
import com.github.michaelbull.result.runCatching
import com.iamincendium.spacetraders.api.result.APIResult
import com.iamincendium.spacetraders.api.error.APIError
import com.iamincendium.spacetraders.api.error.UnexpectedError

/**
 * Similar to [runCatching] except the [Result] error type is remapped to a generic subclass of [APIError].
 */
internal inline fun <T : Any> runOrError(block: () -> T): APIResult<T> =
    runCatching(block).mapError { UnexpectedError(it) }

/**
 * Similar to [runCatching] except the [Result] error type is remapped to a generic subclass of [APIError].
 */
internal inline fun <T : Any> runOrErrorAndFlatten(block: () -> APIResult<T>): APIResult<T> =
    when (val result = runOrError(block)) {
        is Err -> result
        is Ok -> result.value
    }
