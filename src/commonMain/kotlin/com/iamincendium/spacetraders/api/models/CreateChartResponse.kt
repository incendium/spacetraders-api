package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class CreateChartResponse(
    @SerialName("chart") val chart: Chart,
    @SerialName("waypoint") val waypoint: Waypoint,
)
