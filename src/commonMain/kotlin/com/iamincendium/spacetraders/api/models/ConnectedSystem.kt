package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ConnectedSystem(
    @SerialName("symbol") val symbol: String,
    @SerialName("sectorSymbol") val sectorSymbol: String,
    @SerialName("type") val type: SystemType,
    @SerialName("x") val x: Int,
    @SerialName("y") val y: Int,
    @SerialName("distance") val distance: Int,
    @SerialName("factionSymbol") val factionSymbol: String? = null,
)

