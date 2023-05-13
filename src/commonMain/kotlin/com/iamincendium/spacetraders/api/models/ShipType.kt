package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ShipType {
    @SerialName("SHIP_PROBE") PROBE,
    @SerialName("SHIP_MINING_DRONE") MINING_DRONE,
    @SerialName("SHIP_INTERCEPTOR") INTERCEPTOR,
    @SerialName("SHIP_LIGHT_HAULER") LIGHT_HAULER,
    @SerialName("SHIP_COMMAND_FRIGATE") COMMAND_FRIGATE,
    @SerialName("SHIP_EXPLORER") EXPLORER,
    @SerialName("SHIP_HEAVY_FREIGHTER") HEAVY_FREIGHTER,
    @SerialName("SHIP_LIGHT_SHUTTLE") LIGHT_SHUTTLE,
    @SerialName("SHIP_ORE_HOUND") ORE_HOUND,
    @SerialName("SHIP_REFINING_FREIGHTER") REFINING_FREIGHTER,
}
