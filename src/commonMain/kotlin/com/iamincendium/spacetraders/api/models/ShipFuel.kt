package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipFuel(
    @SerialName("current") val current: Int,
    @SerialName("capacity") val capacity: Int,
    @SerialName("consumed") val consumed: ShipFuelConsumed? = null,
)
