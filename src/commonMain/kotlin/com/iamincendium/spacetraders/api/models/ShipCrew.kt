package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipCrew(
    @SerialName("current") val current: Int,
    @SerialName("required") val required: Int,
    @SerialName("capacity") val capacity: Int,
    @SerialName("rotation") val rotation: Rotation = Rotation.STRICT,
    @SerialName("morale") val morale: Int,
    @SerialName("wages") val wages: Int,
) {
    @Serializable
    public enum class Rotation {
        @SerialName("STRICT") STRICT,
        @SerialName("RELAXED") RELAXED,
    }
}
