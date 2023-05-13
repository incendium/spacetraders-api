package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipCargoItem(
    @SerialName("symbol") val symbol: String,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String,
    @SerialName("units") val units: Int,
)
