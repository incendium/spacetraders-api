package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Extraction(
    @SerialName("shipSymbol") val shipSymbol: String,
    @SerialName("yield") val yield: ExtractionYield,
)
