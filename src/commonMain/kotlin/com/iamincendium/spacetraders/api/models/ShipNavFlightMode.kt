package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ShipNavFlightMode {
    @SerialName("DRIFT") DRIFT,
    @SerialName("STEALTH") STEALTH,
    @SerialName("CRUISE") CRUISE,
    @SerialName("BURN") BURN,
}
