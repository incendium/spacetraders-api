package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DeliveredContract(
    @SerialName("contract") val contract: Contract,
    @SerialName("cargo") val cargo: ShipCargo,
)
