package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request payload sent when performing jumps.
 *
 * @param systemSymbol The symbol of the system to jump to.
 */
@Serializable
public data class JumpShipRequest(
    @SerialName("systemSymbol") val systemSymbol: String,
)
