package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JumpShipResponse(
    @SerialName("cooldown") val cooldown: Cooldown,
    @SerialName("nav") val nav: ShipNav? = null,
)
