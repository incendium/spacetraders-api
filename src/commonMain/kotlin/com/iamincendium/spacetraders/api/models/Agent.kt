package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Agent(
    @SerialName("accountId") val accountId: String,
    @SerialName("symbol") val symbol: String,
    @SerialName("headquarters") val headquarters: String,
    @SerialName("credits") val credits: Int,
)
