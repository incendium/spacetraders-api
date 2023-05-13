package com.iamincendium.spacetraders.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipNavRoute(
    @SerialName("destination") val destination: ShipNavRouteWaypoint,
    @SerialName("departure") val departure: ShipNavRouteWaypoint,
    @SerialName("departureTime") val departureTime: Instant,
    @SerialName("arrival") val arrival: Instant,
)
