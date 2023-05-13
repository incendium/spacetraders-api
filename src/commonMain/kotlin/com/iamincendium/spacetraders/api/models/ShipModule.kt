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
        @SerialName("MODULE_MINERAL_PROCESSOR_I") MODULE_MINERAL_PROCESSOR_I,
        @SerialName("MODULE_CARGO_HOLD_I") MODULE_CARGO_HOLD_I,
        @SerialName("MODULE_CREW_QUARTERS_I") MODULE_CREW_QUARTERS_I,
        @SerialName("MODULE_ENVOY_QUARTERS_I") MODULE_ENVOY_QUARTERS_I,
        @SerialName("MODULE_PASSENGER_CABIN_I") MODULE_PASSENGER_CABIN_I,
        @SerialName("MODULE_MICRO_REFINERY_I") MODULE_MICRO_REFINERY_I,
        @SerialName("MODULE_ORE_REFINERY_I") MODULE_ORE_REFINERY_I,
        @SerialName("MODULE_FUEL_REFINERY_I") MODULE_FUEL_REFINERY_I,
        @SerialName("MODULE_SCIENCE_LAB_I") MODULE_SCIENCE_LAB_I,
        @SerialName("MODULE_JUMP_DRIVE_I") MODULE_JUMP_DRIVE_I,
        @SerialName("MODULE_JUMP_DRIVE_II") MODULE_JUMP_DRIVE_II,
        @SerialName("MODULE_JUMP_DRIVE_III") MODULE_JUMP_DRIVE_III,
        @SerialName("MODULE_WARP_DRIVE_I") MODULE_WARP_DRIVE_I,
        @SerialName("MODULE_WARP_DRIVE_II") MODULE_WARP_DRIVE_II,
        @SerialName("MODULE_WARP_DRIVE_III") MODULE_WARP_DRIVE_III,
        @SerialName("MODULE_SHIELD_GENERATOR_I") MODULE_SHIELD_GENERATOR_I,
        @SerialName("MODULE_SHIELD_GENERATOR_II") MODULE_SHIELD_GENERATOR_II,
    }
}
