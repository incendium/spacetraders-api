package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request payload sent when performing navigation.
 *
 * @param waypointSymbol The symbol of the waypoint to navigate to.
 */
@Serializable
public data class NavigateShipRequest(
    @SerialName("waypointSymbol") val waypointSymbol: String,
)
