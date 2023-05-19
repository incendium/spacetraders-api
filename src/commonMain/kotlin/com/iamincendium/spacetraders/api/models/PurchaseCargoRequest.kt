package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request payload sent when purchasing cargo.
 *
 * @param symbol The symbol of the cargo to purchase.
 * @param units The amount of cargo to purchase.
 */
@Serializable
public data class PurchaseCargoRequest(
    @SerialName("symbol") val symbol: String,
    @SerialName("units") val units: Int,
)
