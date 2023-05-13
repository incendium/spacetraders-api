package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PurchaseShipResponse(
    @SerialName("agent") val agent: Agent,
    @SerialName("ship") val ship: Ship,
    @SerialName("transaction") val transaction: ShipyardTransaction,
)
