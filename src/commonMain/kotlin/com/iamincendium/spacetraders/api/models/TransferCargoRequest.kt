package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request payload sent when transferring cargo.
 *
 * @param tradeSymbol The symbol of the cargo to transfer
 * @param units The amount of cargo to transfer
 * @param shipSymbol The symbol of the ship to transfer the cargo to
 */
@Serializable
public data class TransferCargoRequest(
    @SerialName("tradeSymbol") val tradeSymbol: String,
    @SerialName("units") val units: Int,
    @SerialName("shipSymbol") val shipSymbol: String,
)
