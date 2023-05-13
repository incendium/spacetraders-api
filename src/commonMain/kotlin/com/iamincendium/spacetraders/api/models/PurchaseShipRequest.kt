package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PurchaseShipRequest(
    @SerialName("shipType") val shipType: ShipType,
    @SerialName("waypointSymbol") val waypointSymbol: String,
)
