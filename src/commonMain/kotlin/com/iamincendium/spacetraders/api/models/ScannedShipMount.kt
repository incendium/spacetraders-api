package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ScannedShipMount(
    @SerialName("symbol") val symbol: String,
)
