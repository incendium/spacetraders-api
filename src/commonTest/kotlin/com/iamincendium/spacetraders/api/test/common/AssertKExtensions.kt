package com.iamincendium.spacetraders.api.test.common

import assertk.Assert
import assertk.assertions.isEqualTo
import com.github.michaelbull.result.Ok
import com.iamincendium.spacetraders.api.models.PageData
import com.iamincendium.spacetraders.api.models.PagedResponse
import com.iamincendium.spacetraders.api.models.Response
import com.iamincendium.spacetraders.api.result.APIResult

fun <T : Any> validResponse(payload: T): APIResult<Response<T>> = Ok(Response(payload))

fun <T : Any> validPagedResponse(payload: T, pageData: PageData): APIResult<PagedResponse<T>> {
    return Ok(PagedResponse(payload, pageData))
}

/**
 * Asserts the value is a valid response.
 */
fun <T : Any> Assert<APIResult<Response<T>>>.isValidResponse(expected: T) = isEqualTo(validResponse(expected))

/**
 * Asserts the value is a valid paged response.
 */
fun <T : Any> Assert<APIResult<PagedResponse<T>>>.isValidPagedResponse(expected: T, pageData: PageData) =
    isEqualTo(validPagedResponse(expected, pageData))
