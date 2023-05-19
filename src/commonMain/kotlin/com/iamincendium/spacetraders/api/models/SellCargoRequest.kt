package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request payload sent when selling cargo.
 *
 * @param symbol The symbol of the cargo to sell.
 * @param units The amount of cargo to sell.
 */
@Serializable
public data class SellCargoRequest(
    @SerialName("symbol") val symbol: String,
    @SerialName("units") val units: Int,
)
