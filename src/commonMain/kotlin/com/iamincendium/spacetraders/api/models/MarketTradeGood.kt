package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class MarketTradeGood(
    @SerialName("symbol") val symbol: String,
    @SerialName("tradeVolume") val tradeVolume: Int,
    @SerialName("supply") val supply: Supply,
    @SerialName("purchasePrice") val purchasePrice: Int,
    @SerialName("sellPrice") val sellPrice: Int,
) {
    @Serializable
    public enum class Supply {
        @SerialName("SCARCE") SCARCE,
        @SerialName("LIMITED") LIMITED,
        @SerialName("MODERATE") MODERATE,
        @SerialName("ABUNDANT") ABUNDANT,
    }
}
