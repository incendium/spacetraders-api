package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipFrame(
    @SerialName("symbol") val symbol: Symbol,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String,
    @SerialName("moduleSlots") val moduleSlots: Int,
    @SerialName("mountingPoints") val mountingPoints: Int,
    @SerialName("fuelCapacity") val fuelCapacity: Int,
    @SerialName("requirements") val requirements: ShipRequirements,
    @SerialName("condition") val condition: Int? = null,
) {
    @Serializable
    public enum class Symbol {
        @SerialName("FRAME_PROBE") FRAME_PROBE,
        @SerialName("FRAME_DRONE") FRAME_DRONE,
        @SerialName("FRAME_INTERCEPTOR") FRAME_INTERCEPTOR,
        @SerialName("FRAME_RACER") FRAME_RACER,
        @SerialName("FRAME_FIGHTER") FRAME_FIGHTER,
        @SerialName("FRAME_FRIGATE") FRAME_FRIGATE,
        @SerialName("FRAME_SHUTTLE") FRAME_SHUTTLE,
        @SerialName("FRAME_EXPLORER") FRAME_EXPLORER,
        @SerialName("FRAME_MINER") FRAME_MINER,
        @SerialName("FRAME_LIGHT_FREIGHTER") FRAME_LIGHT_FREIGHTER,
        @SerialName("FRAME_HEAVY_FREIGHTER") FRAME_HEAVY_FREIGHTER,
        @SerialName("FRAME_TRANSPORT") FRAME_TRANSPORT,
        @SerialName("FRAME_DESTROYER") FRAME_DESTROYER,
        @SerialName("FRAME_CRUISER") FRAME_CRUISER,
        @SerialName("FRAME_CARRIER") FRAME_CARRIER,
    }
}
