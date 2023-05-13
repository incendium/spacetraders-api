package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ScannedShipMountsInner(
    @SerialName("symbol") val symbol: String,
)
