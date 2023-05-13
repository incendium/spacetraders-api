package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class WaypointScanResult(
    @SerialName("cooldown") val cooldown: Cooldown,
    @SerialName("waypoints") val waypoints: List<ScannedWaypoint>,
)
