package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipRequirements(
    @SerialName("power") val power: Int? = null,
    @SerialName("crew") val crew: Int? = null,
    @SerialName("slots") val slots: Int? = null,
)
