package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ShipType {
    @SerialName("SHIP_PROBE") SHIP_PROBE,
    @SerialName("SHIP_MINING_DRONE") SHIP_MINING_DRONE,
    @SerialName("SHIP_INTERCEPTOR") SHIP_INTERCEPTOR,
    @SerialName("SHIP_LIGHT_HAULER") SHIP_LIGHT_HAULER,
    @SerialName("SHIP_COMMAND_FRIGATE") SHIP_COMMAND_FRIGATE,
    @SerialName("SHIP_EXPLORER") SHIP_EXPLORER,
    @SerialName("SHIP_HEAVY_FREIGHTER") SHIP_HEAVY_FREIGHTER,
    @SerialName("SHIP_LIGHT_SHUTTLE") SHIP_LIGHT_SHUTTLE,
    @SerialName("SHIP_ORE_HOUND") SHIP_ORE_HOUND,
    @SerialName("SHIP_REFINING_FREIGHTER") SHIP_REFINING_FREIGHTER,
}
