package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ContractPayment(
    @SerialName("onAccepted") val onAccepted: Int,
    @SerialName("onFulfilled") val onFulfilled: Int,
)
