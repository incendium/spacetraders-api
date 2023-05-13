package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipScanResult(
    @SerialName("cooldown") val cooldown: Cooldown,
    @SerialName("ships") val ships: List<ScannedShip>,
)
