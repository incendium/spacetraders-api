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
        @SerialName("FRAME_PROBE") PROBE,
        @SerialName("FRAME_DRONE") DRONE,
        @SerialName("FRAME_INTERCEPTOR") INTERCEPTOR,
        @SerialName("FRAME_RACER") RACER,
        @SerialName("FRAME_FIGHTER") FIGHTER,
        @SerialName("FRAME_FRIGATE") FRIGATE,
        @SerialName("FRAME_SHUTTLE") SHUTTLE,
        @SerialName("FRAME_EXPLORER") EXPLORER,
        @SerialName("FRAME_MINER") MINER,
        @SerialName("FRAME_LIGHT_FREIGHTER") LIGHT_FREIGHTER,
        @SerialName("FRAME_HEAVY_FREIGHTER") HEAVY_FREIGHTER,
        @SerialName("FRAME_TRANSPORT") TRANSPORT,
        @SerialName("FRAME_DESTROYER") DESTROYER,
        @SerialName("FRAME_CRUISER") CRUISER,
        @SerialName("FRAME_CARRIER") CARRIER,
    }
}
