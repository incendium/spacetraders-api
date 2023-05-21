package com.iamincendium.spacetraders.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Cooldown(
    @SerialName("shipSymbol") val shipSymbol: String,
    @SerialName("totalSeconds") val totalSeconds: Int,
    @SerialName("remainingSeconds") val remainingSeconds: Int,
    @SerialName("expiration") val expiration: Instant? = null,
)
