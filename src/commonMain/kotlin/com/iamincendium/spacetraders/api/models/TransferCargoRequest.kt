package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class TransferCargoRequest(
    @SerialName("tradeSymbol") val tradeSymbol: String,
    @SerialName("units") val units: Int,
    @SerialName("shipSymbol") val shipSymbol: String,
)
