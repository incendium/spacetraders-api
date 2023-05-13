package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Shipyard(
    @SerialName("symbol") val symbol: String,
    @SerialName("shipTypes") val shipTypes: List<ShipyardShipTypesInner>,
    @SerialName("transactions") val transactions: List<ShipyardTransaction>? = null,
    @SerialName("ships") val ships: List<ShipyardShip>? = null,
)
