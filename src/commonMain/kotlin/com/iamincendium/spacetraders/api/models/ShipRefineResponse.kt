package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipRefineResponse(
    @SerialName("cargo") val cargo: ShipCargo,
    @SerialName("cooldown") val cooldown: Cooldown,
    @SerialName("produced") val produced: List<ManipulatedAmount>,
    @SerialName("consumed") val consumed: List<ManipulatedAmount>,
) {
    @Serializable
    public data class ManipulatedAmount(
        @SerialName("tradeSymbol") val tradeSymbol: String? = null,
        @SerialName("units") val units: Int? = null,
    )
}
