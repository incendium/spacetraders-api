package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExtractResourcesResponse(
    @SerialName("cooldown") val cooldown: Cooldown,
    @SerialName("extraction") val extraction: Extraction,
    @SerialName("cargo") val cargo: ShipCargo,
)
