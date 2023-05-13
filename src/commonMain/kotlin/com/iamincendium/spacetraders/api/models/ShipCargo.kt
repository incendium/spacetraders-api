package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipCargo(
    @SerialName("capacity") val capacity: Int,
    @SerialName("units") val units: Int,
    @SerialName("inventory") val inventory: List<ShipCargoItem>,
)
