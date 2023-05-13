package com.iamincendium.spacetraders.api.error

import io.ktor.http.*
import kotlinx.serialization.json.JsonObject

public data class GenericServerError(
    override val statusCode: HttpStatusCode,
    override val message: String,
    override val code: Int,
    override val extraData: JsonObject,
) : ServerError
