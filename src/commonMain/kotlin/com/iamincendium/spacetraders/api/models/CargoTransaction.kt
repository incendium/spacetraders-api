package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class CargoTransaction(
    @SerialName("agent") val agent: Agent,
    @SerialName("cargo") val cargo: ShipCargo,
    @SerialName("transaction") val transaction: MarketTransaction,
)
