package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipNav(
    @SerialName("systemSymbol") val systemSymbol: String,
    @SerialName("waypointSymbol") val waypointSymbol: String,
    @SerialName("route") val route: ShipNavRoute,
    @SerialName("status") val status: ShipNavStatus,
    @SerialName("flightMode") val flightMode: ShipNavFlightMode = ShipNavFlightMode.CRUISE,
)
