package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Registration(
    @SerialName("agent") val agent: Agent,
    @SerialName("contract") val `contract`: Contract,
    @SerialName("faction") val faction: Faction,
    @SerialName("ship") val ship: Ship,
    @SerialName("token") val token: String,
)
