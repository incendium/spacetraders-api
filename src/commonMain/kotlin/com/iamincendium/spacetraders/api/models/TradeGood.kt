package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class TradeGood(
    @SerialName("symbol") val symbol: TradeSymbol,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String,
)
