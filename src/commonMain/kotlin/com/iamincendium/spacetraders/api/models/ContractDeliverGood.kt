package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ContractDeliverGood(
    @SerialName("tradeSymbol") val tradeSymbol: String,
    @SerialName("destinationSymbol") val destinationSymbol: String,
    @SerialName("unitsRequired") val unitsRequired: Int,
    @SerialName("unitsFulfilled") val unitsFulfilled: Int,
)
