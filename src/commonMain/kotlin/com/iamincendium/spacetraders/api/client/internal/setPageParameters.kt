package com.iamincendium.spacetraders.api.client.internal

import io.ktor.client.request.*

/**
 * Set the page parameters based on the provided page
 */
internal fun HttpRequestBuilder.setPageParameters(page: Int?, limit: Int?) = url {
    if (page != null) parameters.append("page", page.toString())
    if (limit != null) parameters.append("limit", limit.toString())
}
