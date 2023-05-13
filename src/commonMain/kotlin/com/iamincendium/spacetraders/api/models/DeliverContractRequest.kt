package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DeliverContractRequest(
    @SerialName("shipSymbol") val shipSymbol: String,
    @SerialName("tradeSymbol") val tradeSymbol: String,
    @SerialName("units") val units: Int,
)
