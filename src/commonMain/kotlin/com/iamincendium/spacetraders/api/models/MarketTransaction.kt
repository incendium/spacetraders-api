package com.iamincendium.spacetraders.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class MarketTransaction(
    @SerialName("waypointSymbol") val waypointSymbol: String,
    @SerialName("shipSymbol") val shipSymbol: String,
    @SerialName("tradeSymbol") val tradeSymbol: String,
    @SerialName("type") val type: Type,
    @SerialName("units") val units: Int,
    @SerialName("pricePerUnit") val pricePerUnit: Int,
    @SerialName("totalPrice") val totalPrice: Int,
    @SerialName("timestamp") val timestamp: Instant,
) {
    @Serializable
    public enum class Type {
        @SerialName("PURCHASE") PURCHASE,
        @SerialName("SELL") SELL,
    }
}
