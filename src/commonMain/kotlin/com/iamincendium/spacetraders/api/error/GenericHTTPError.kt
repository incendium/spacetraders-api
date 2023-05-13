package com.iamincendium.spacetraders.api.error

import io.ktor.http.*

public data class GenericHTTPError(override val statusCode: HttpStatusCode, override val message: String) : HTTPError {
    public constructor(statusCode: HttpStatusCode) : this(statusCode, statusCode.description)
}
