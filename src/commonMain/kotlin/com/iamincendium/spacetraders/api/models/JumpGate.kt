package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JumpGate(
    @SerialName("jumpRange") val jumpRange: Int,
    @SerialName("connectedSystems") val connectedSystems: List<ConnectedSystem>,
    @SerialName("factionSymbol") val factionSymbol: String? = null,
)
