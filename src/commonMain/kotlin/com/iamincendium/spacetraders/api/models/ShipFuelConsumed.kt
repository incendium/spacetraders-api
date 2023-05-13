package com.iamincendium.spacetraders.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipFuelConsumed(
    @SerialName("amount") val amount: Int,
    @SerialName("timestamp") val timestamp: Instant,
)
