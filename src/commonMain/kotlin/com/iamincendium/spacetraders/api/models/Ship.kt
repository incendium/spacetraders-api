package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Ship(
    @SerialName("symbol") val symbol: String,
    @SerialName("registration") val registration: ShipRegistration,
    @SerialName("nav") val nav: ShipNav,
    @SerialName("crew") val crew: ShipCrew,
    @SerialName("frame") val frame: ShipFrame,
    @SerialName("reactor") val reactor: ShipReactor,
    @SerialName("engine") val engine: ShipEngine,
    @SerialName("modules") val modules: List<ShipModule>,
    @SerialName("mounts") val mounts: List<ShipMount>,
    @SerialName("cargo") val cargo: ShipCargo,
    @SerialName("fuel") val fuel: ShipFuel,
)

