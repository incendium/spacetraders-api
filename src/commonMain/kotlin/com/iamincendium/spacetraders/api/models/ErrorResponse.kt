package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
internal data class ErrorResponse(
    @SerialName("error") val error: Error,
) {
    @Serializable
    internal data class Error(
        @SerialName("message") val message: String,
        @SerialName("code") val code: Int,
        @SerialName("data") val data: JsonObject = JsonObject(mapOf()),
    )
}
