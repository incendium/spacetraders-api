package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ShipNavStatus {
    @SerialName("IN_TRANSIT") IN_TRANSIT,
    @SerialName("IN_ORBIT") IN_ORBIT,
    @SerialName("DOCKED") DOCKED,
}
