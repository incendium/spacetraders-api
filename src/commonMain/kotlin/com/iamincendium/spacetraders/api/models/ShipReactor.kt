package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipReactor(
    @SerialName("symbol") val symbol: Symbol,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String,
    @SerialName("powerOutput") val powerOutput: Int,
    @SerialName("requirements") val requirements: ShipRequirements,
    @SerialName("condition") val condition: Int? = null,
) {
    @Serializable
    public enum class Symbol {
        @SerialName("REACTOR_SOLAR_I") SOLAR_I,
        @SerialName("REACTOR_FUSION_I") FUSION_I,
        @SerialName("REACTOR_FISSION_I") FISSION_I,
        @SerialName("REACTOR_CHEMICAL_I") CHEMICAL_I,
        @SerialName("REACTOR_ANTIMATTER_I") ANTIMATTER_I,
    }
}
