package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PatchShipNavRequest(
    @SerialName("flightMode") val flightMode: ShipNavFlightMode? = ShipNavFlightMode.CRUISE,
)
