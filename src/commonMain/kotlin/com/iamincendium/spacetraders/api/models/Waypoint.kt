package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Waypoint(
    @SerialName("symbol") val symbol: String,
    @SerialName("type") val type: WaypointType,
    @SerialName("systemSymbol") val systemSymbol: String,
    @SerialName("x") val x: Int,
    @SerialName("y") val y: Int,
    @SerialName("orbitals") val orbitals: List<WaypointOrbital>,
    @SerialName("traits") val traits: List<WaypointTrait>,
    @SerialName("faction") val faction: WaypointFaction? = null,
    @SerialName("chart") val chart: Chart? = null,
)
