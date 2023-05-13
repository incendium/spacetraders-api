package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Shipyard(
    @SerialName("symbol") val symbol: String,
    @SerialName("shipTypes") val shipTypes: List<ShipyardShipType>,
    @SerialName("transactions") val transactions: List<ShipyardTransaction> = listOf(),
    @SerialName("ships") val ships: List<ShipyardShip> = listOf(),
)
