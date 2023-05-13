package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipModule(
    @SerialName("symbol") val symbol: Symbol,
    @SerialName("name") val name: String,
    @SerialName("requirements") val requirements: ShipRequirements,
    @SerialName("capacity") val capacity: Int? = null,
    @SerialName("range") val range: Int? = null,
    @SerialName("description") val description: String? = null,
) {
    @Serializable
    public enum class Symbol {
        @SerialName("MODULE_MINERAL_PROCESSOR_I") MINERAL_PROCESSOR_I,
        @SerialName("MODULE_CARGO_HOLD_I") CARGO_HOLD_I,
        @SerialName("MODULE_CREW_QUARTERS_I") CREW_QUARTERS_I,
        @SerialName("MODULE_ENVOY_QUARTERS_I") ENVOY_QUARTERS_I,
        @SerialName("MODULE_PASSENGER_CABIN_I") PASSENGER_CABIN_I,
        @SerialName("MODULE_MICRO_REFINERY_I") MICRO_REFINERY_I,
        @SerialName("MODULE_ORE_REFINERY_I") ORE_REFINERY_I,
        @SerialName("MODULE_FUEL_REFINERY_I") FUEL_REFINERY_I,
        @SerialName("MODULE_SCIENCE_LAB_I") SCIENCE_LAB_I,
        @SerialName("MODULE_JUMP_DRIVE_I") JUMP_DRIVE_I,
        @SerialName("MODULE_JUMP_DRIVE_II") JUMP_DRIVE_II,
        @SerialName("MODULE_JUMP_DRIVE_III") JUMP_DRIVE_III,
        @SerialName("MODULE_WARP_DRIVE_I") WARP_DRIVE_I,
        @SerialName("MODULE_WARP_DRIVE_II") WARP_DRIVE_II,
        @SerialName("MODULE_WARP_DRIVE_III") WARP_DRIVE_III,
        @SerialName("MODULE_SHIELD_GENERATOR_I") SHIELD_GENERATOR_I,
        @SerialName("MODULE_SHIELD_GENERATOR_II") SHIELD_GENERATOR_II,
    }
}
