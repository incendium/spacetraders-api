package com.iamincendium.spacetraders.api.error

import io.ktor.http.*
import kotlinx.serialization.json.JsonObject

public data class MarketError(
    override val statusCode: HttpStatusCode,
    override val message: String,
    override val code: APIErrorCode.Market,
    override val extraData: JsonObject,
) : ServerError
