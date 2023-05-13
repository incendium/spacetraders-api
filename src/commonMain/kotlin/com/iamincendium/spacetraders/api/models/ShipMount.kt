package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipMount(
    @SerialName("symbol") val symbol: Symbol,
    @SerialName("name") val name: String,
    @SerialName("requirements") val requirements: ShipRequirements,
    @SerialName("description") val description: String? = null,
    @SerialName("strength") val strength: Int? = null,
    @SerialName("deposits") val deposits: List<Deposits>? = null,
) {
    @Serializable
    public enum class Symbol {
        @SerialName("MOUNT_GAS_SIPHON_I") MOUNT_GAS_SIPHON_I,
        @SerialName("MOUNT_GAS_SIPHON_II") MOUNT_GAS_SIPHON_II,
        @SerialName("MOUNT_GAS_SIPHON_III") MOUNT_GAS_SIPHON_III,
        @SerialName("MOUNT_SURVEYOR_I") MOUNT_SURVEYOR_I,
        @SerialName("MOUNT_SURVEYOR_II") MOUNT_SURVEYOR_II,
        @SerialName("MOUNT_SURVEYOR_III") MOUNT_SURVEYOR_III,
        @SerialName("MOUNT_SENSOR_ARRAY_I") MOUNT_SENSOR_ARRAY_I,
        @SerialName("MOUNT_SENSOR_ARRAY_II") MOUNT_SENSOR_ARRAY_II,
        @SerialName("MOUNT_SENSOR_ARRAY_III") MOUNT_SENSOR_ARRAY_III,
        @SerialName("MOUNT_MINING_LASER_I") MOUNT_MINING_LASER_I,
        @SerialName("MOUNT_MINING_LASER_II") MOUNT_MINING_LASER_II,
        @SerialName("MOUNT_MINING_LASER_III") MOUNT_MINING_LASER_III,
        @SerialName("MOUNT_LASER_CANNON_I") MOUNT_LASER_CANNON_I,
        @SerialName("MOUNT_MISSILE_LAUNCHER_I") MOUNT_MISSILE_LAUNCHER_I,
        @SerialName("MOUNT_TURRET_I") MOUNT_TURRET_I,
    }

    @Serializable
    public enum class Deposits {
        @SerialName("QUARTZ_SAND") QUARTZ_SAND,
        @SerialName("SILICON_CRYSTALS") SILICON_CRYSTALS,
        @SerialName("PRECIOUS_STONES") PRECIOUS_STONES,
        @SerialName("ICE_WATER") ICE_WATER,
        @SerialName("AMMONIA_ICE") AMMONIA_ICE,
        @SerialName("IRON_ORE") IRON_ORE,
        @SerialName("COPPER_ORE") COPPER_ORE,
        @SerialName("SILVER_ORE") SILVER_ORE,
        @SerialName("ALUMINUM_ORE") ALUMINUM_ORE,
        @SerialName("GOLD_ORE") GOLD_ORE,
        @SerialName("PLATINUM_ORE") PLATINUM_ORE,
        @SerialName("DIAMONDS") DIAMONDS,
        @SerialName("URANITE_ORE") URANITE_ORE,
        @SerialName("MERITIUM_ORE") MERITIUM_ORE,
    }
}
