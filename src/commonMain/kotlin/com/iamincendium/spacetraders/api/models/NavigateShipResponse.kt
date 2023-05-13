package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class NavigateShipResponse(
    @SerialName("fuel") val fuel: ShipFuel,
    @SerialName("nav") val nav: ShipNav,
)
