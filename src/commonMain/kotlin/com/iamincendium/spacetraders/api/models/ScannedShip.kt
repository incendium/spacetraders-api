package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ScannedShip(
    @SerialName("symbol") val symbol: String,
    @SerialName("registration") val registration: ShipRegistration,
    @SerialName("nav") val nav: ShipNav,
    @SerialName("engine") val engine: ScannedShipEngine,
    @SerialName("frame") val frame: ScannedShipFrame? = null,
    @SerialName("reactor") val reactor: ScannedShipReactor? = null,
    @SerialName("mounts") val mounts: List<ScannedShipMount>? = null,
)
