package com.iamincendium.spacetraders.api.error

import io.ktor.http.*
import kotlinx.serialization.json.JsonObject

public data class AccountError(
    override val statusCode: HttpStatusCode,
    override val message: String,
    override val code: APIErrorCode.Account,
    override val extraData: JsonObject,
) : ServerError
