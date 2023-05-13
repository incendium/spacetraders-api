package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RefuelShipResponse(
    @SerialName("agent") val agent: Agent,
    @SerialName("fuel") val fuel: ShipFuel,
)
