package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The request sent when delivering a contract.
 *
 * @param shipSymbol The symbol of the ship to send the cargo from.
 * @param tradeSymbol The symbol of the trade good to send.
 * @param units The amount of trade goods to send.
 */
@Serializable
public data class DeliverContractRequest(
    @SerialName("shipSymbol") val shipSymbol: String,
    @SerialName("tradeSymbol") val tradeSymbol: String,
    @SerialName("units") val units: Int,
)
