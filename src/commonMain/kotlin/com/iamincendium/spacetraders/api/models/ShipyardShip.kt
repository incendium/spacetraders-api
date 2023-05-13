package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipyardShip(
    @SerialName("name") val name: String,
    @SerialName("description") val description: String,
    @SerialName("purchasePrice") val purchasePrice: Int,
    @SerialName("frame") val frame: ShipFrame,
    @SerialName("reactor") val reactor: ShipReactor,
    @SerialName("engine") val engine: ShipEngine,
    @SerialName("modules") val modules: List<ShipModule>,
    @SerialName("mounts") val mounts: List<ShipMount>,
    @SerialName("type") val type: ShipType? = null,
)
