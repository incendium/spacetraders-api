package com.iamincendium.spacetraders.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipyardTransaction(
    @SerialName("waypointSymbol") val waypointSymbol: String,
    @SerialName("shipSymbol") val shipSymbol: String,
    @SerialName("price") val price: Int,
    @SerialName("agentSymbol") val agentSymbol: String,
    @SerialName("timestamp") val timestamp: Instant,
)
