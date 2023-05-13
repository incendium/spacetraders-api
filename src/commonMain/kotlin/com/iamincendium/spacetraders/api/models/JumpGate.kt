package com.iamincendium.spacetraders.api.models

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JumpGate(
    @SerialName("jumpRange") @Contextual val jumpRange: BigDecimal,
    @SerialName("connectedSystems") val connectedSystems: List<ConnectedSystem>,
    @SerialName("factionSymbol") val factionSymbol: String? = null,
)
