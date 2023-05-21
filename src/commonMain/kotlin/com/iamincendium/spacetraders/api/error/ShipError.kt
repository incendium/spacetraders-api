package com.iamincendium.spacetraders.api.error

import io.ktor.http.*
import kotlinx.serialization.json.JsonObject

public data class ShipError(
    override val statusCode: HttpStatusCode,
    override val message: String,
    override val code: APIErrorCode.Ship,
    override val extraData: JsonObject,
) : ServerError
