package com.iamincendium.spacetraders.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ContractTerms(
    @SerialName("deadline") val deadline: Instant,
    @SerialName("payment") val payment: ContractPayment,
    @SerialName("deliver") val deliver: List<ContractDeliverGood>? = null,
)
