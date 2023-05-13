package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Market(
    @SerialName("symbol") val symbol: String,
    @SerialName("exports") val exports: List<TradeGood>,
    @SerialName("imports") val imports: List<TradeGood>,
    @SerialName("exchange") val exchange: List<TradeGood>,
    @SerialName("transactions") val transactions: List<MarketTransaction>? = null,
    @SerialName("tradeGoods") val tradeGoods: List<MarketTradeGood>? = null,
)
