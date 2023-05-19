package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request payload sent when purchasing a ship.
 *
 * @param shipType The type of ship to purchase.
 * @param waypointSymbol The symbol of the waypoint to purchase the ship at.
 */
@Serializable
public data class PurchaseShipRequest(
    @SerialName("shipType") val shipType: ShipType,
    @SerialName("waypointSymbol") val waypointSymbol: String,
)
