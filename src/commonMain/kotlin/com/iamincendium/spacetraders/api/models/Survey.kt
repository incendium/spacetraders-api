package com.iamincendium.spacetraders.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Survey(
    @SerialName("signature") val signature: String,
    @SerialName("symbol") val symbol: String,
    @SerialName("deposits") val deposits: List<SurveyDeposit>,
    @SerialName("expiration") val expiration: Instant,
    @SerialName("size") val propertySize: PropertySize,
) {
    @Serializable
    public enum class PropertySize {
        @SerialName("SMALL") SMALL,
        @SerialName("MODERATE") MODERATE,
        @SerialName("LARGE") LARGE,
    }
}
