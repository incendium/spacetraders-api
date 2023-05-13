package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class SystemScanResult(
    @SerialName("cooldown") val cooldown: Cooldown,
    @SerialName("systems") val systems: List<ScannedSystem>,
)
