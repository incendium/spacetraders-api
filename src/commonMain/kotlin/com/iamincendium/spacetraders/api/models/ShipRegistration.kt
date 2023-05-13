package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipRegistration(
    @SerialName("name") val name: String,
    @SerialName("factionSymbol") val factionSymbol: String,
    @SerialName("role") val role: ShipRole,
)
