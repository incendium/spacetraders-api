package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request payload sent when updating the ship nav.
 *
 * @param flightMode The new flight mode to set.
 */
@Serializable
public data class UpdateShipNavRequest(
    @SerialName("flightMode") val flightMode: ShipNavFlightMode? = ShipNavFlightMode.CRUISE,
)
