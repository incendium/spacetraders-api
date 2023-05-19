package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request payload sent when refining in a ship.
 *
 * @param symbol The symbol of the processed material to produce.
 */
@Serializable
public data class ShipRefineRequest(
    @SerialName("produce") val symbol: Symbol,
) {
    @Serializable
    public enum class Symbol {
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
