package com.iamincendium.spacetraders.api.error

import io.ktor.http.*

public sealed interface HTTPError : APIError {
    public val statusCode: HttpStatusCode
}
