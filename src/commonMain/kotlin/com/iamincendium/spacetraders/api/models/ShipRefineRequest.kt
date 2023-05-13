package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipRefineRequest(
    @SerialName("produce") val produce: Produce,
) {
    @Serializable
    public enum class Produce {
        @SerialName("IRON") IRON,
        @SerialName("COPPER") COPPER,
        @SerialName("SILVER") SILVER,
        @SerialName("GOLD") GOLD,
        @SerialName("ALUMINUM") ALUMINUM,
        @SerialName("PLATINUM") PLATINUM,
        @SerialName("URANITE") URANITE,
        @SerialName("MERITIUM") MERITIUM,
        @SerialName("FUEL") FUEL,
    }
}
