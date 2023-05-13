package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ScannedShipReactor(
    @SerialName("symbol") val symbol: String,
)
