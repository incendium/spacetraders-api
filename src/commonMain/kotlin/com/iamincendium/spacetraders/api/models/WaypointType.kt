package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class WaypointType {
    @SerialName("PLANET") PLANET,
    @SerialName("GAS_GIANT") GAS_GIANT,
    @SerialName("MOON") MOON,
    @SerialName("ORBITAL_STATION") ORBITAL_STATION,
    @SerialName("JUMP_GATE") JUMP_GATE,
    @SerialName("ASTEROID_FIELD") ASTEROID_FIELD,
    @SerialName("NEBULA") NEBULA,
    @SerialName("DEBRIS_FIELD") DEBRIS_FIELD,
    @SerialName("GRAVITY_WELL") GRAVITY_WELL,
}
