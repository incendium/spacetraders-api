package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request payload sent when jettisoning cargo.
 *
 * @param symbol The symbol of the cargo to jettison.
 * @param units The amount of cargo to jettison.
 */
@Serializable
public data class JettisonRequest(
    @SerialName("symbol") val symbol: String,
    @SerialName("units") val units: Int,
)
