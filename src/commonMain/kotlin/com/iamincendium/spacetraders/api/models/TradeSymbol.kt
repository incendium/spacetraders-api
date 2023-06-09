package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class TradeSymbol {
    @SerialName("PRECIOUS_STONES") PRECIOUS_STONES,
    @SerialName("QUARTZ_SAND") QUARTZ_SAND,
    @SerialName("SILICON_CRYSTALS") SILICON_CRYSTALS,
    @SerialName("AMMONIA_ICE") AMMONIA_ICE,
    @SerialName("LIQUID_HYDROGEN") LIQUID_HYDROGEN,
    @SerialName("LIQUID_NITROGEN") LIQUID_NITROGEN,
    @SerialName("ICE_WATER") ICE_WATER,
    @SerialName("EXOTIC_MATTER") EXOTIC_MATTER,
    @SerialName("ADVANCED_CIRCUITRY") ADVANCED_CIRCUITRY,
    @SerialName("GRAVITON_EMITTERS") GRAVITON_EMITTERS,
    @SerialName("IRON") IRON,
    @SerialName("IRON_ORE") IRON_ORE,
    @SerialName("COPPER") COPPER,
    @SerialName("COPPER_ORE") COPPER_ORE,
    @SerialName("ALUMINUM") ALUMINUM,
    @SerialName("ALUMINUM_ORE") ALUMINUM_ORE,
    @SerialName("SILVER") SILVER,
    @SerialName("SILVER_ORE") SILVER_ORE,
    @SerialName("GOLD") GOLD,
    @SerialName("GOLD_ORE") GOLD_ORE,
    @SerialName("PLATINUM") PLATINUM,
    @SerialName("PLATINUM_ORE") PLATINUM_ORE,
    @SerialName("DIAMONDS") DIAMONDS,
    @SerialName("URANITE") URANITE,
    @SerialName("URANITE_ORE") URANITE_ORE,
    @SerialName("MERITIUM") MERITIUM,
    @SerialName("MERITIUM_ORE") MERITIUM_ORE,
    @SerialName("HYDROCARBON") HYDROCARBON,
    @SerialName("ANTIMATTER") ANTIMATTER,
    @SerialName("FERTILIZERS") FERTILIZERS,
    @SerialName("FABRICS") FABRICS,
    @SerialName("FOOD") FOOD,
    @SerialName("JEWELRY") JEWELRY,
    @SerialName("MACHINERY") MACHINERY,
    @SerialName("FIREARMS") FIREARMS,
    @SerialName("ASSAULT_RIFLES") ASSAULT_RIFLES,
    @SerialName("MILITARY_EQUIPMENT") MILITARY_EQUIPMENT,
    @SerialName("EXPLOSIVES") EXPLOSIVES,
    @SerialName("LAB_INSTRUMENTS") LAB_INSTRUMENTS,
    @SerialName("AMMUNITION") AMMUNITION,
    @SerialName("ELECTRONICS") ELECTRONICS,
    @SerialName("SHIP_PLATING") SHIP_PLATING,
    @SerialName("EQUIPMENT") EQUIPMENT,
    @SerialName("FUEL") FUEL,
    @SerialName("MEDICINE") MEDICINE,
    @SerialName("DRUGS") DRUGS,
    @SerialName("CLOTHING") CLOTHING,
    @SerialName("MICROPROCESSORS") MICROPROCESSORS,
    @SerialName("PLASTICS") PLASTICS,
    @SerialName("POLYNUCLEOTIDES") POLYNUCLEOTIDES,
    @SerialName("BIOCOMPOSITES") BIOCOMPOSITES,
    @SerialName("NANOBOTS") NANOBOTS,
    @SerialName("AI_MAINFRAMES") AI_MAINFRAMES,
    @SerialName("QUANTUM_DRIVES") QUANTUM_DRIVES,
    @SerialName("ROBOTIC_DRONES") ROBOTIC_DRONES,
    @SerialName("CYBER_IMPLANTS") CYBER_IMPLANTS,
    @SerialName("GENE_THERAPEUTICS") GENE_THERAPEUTICS,
    @SerialName("NEURAL_CHIPS") NEURAL_CHIPS,
    @SerialName("MOOD_REGULATORS") MOOD_REGULATORS,
    @SerialName("VIRAL_AGENTS") VIRAL_AGENTS,
    @SerialName("MICRO_FUSION_GENERATORS") MICRO_FUSION_GENERATORS,
    @SerialName("SUPERGRAINS") SUPERGRAINS,
    @SerialName("LASER_RIFLES") LASER_RIFLES,
    @SerialName("HOLOGRAPHICS") HOLOGRAPHICS,
    @SerialName("SHIP_SALVAGE") SHIP_SALVAGE,
    @SerialName("RELIC_TECH") RELIC_TECH,
    @SerialName("NOVEL_LIFEFORMS") NOVEL_LIFEFORMS,
    @SerialName("BOTANICAL_SPECIMENS") BOTANICAL_SPECIMENS,
    @SerialName("CULTURAL_ARTIFACTS") CULTURAL_ARTIFACTS,
    @SerialName("REACTOR_SOLAR_I") REACTOR_SOLAR_I,
    @SerialName("REACTOR_FUSION_I") REACTOR_FUSION_I,
    @SerialName("REACTOR_FISSION_I") REACTOR_FISSION_I,
    @SerialName("REACTOR_CHEMICAL_I") REACTOR_CHEMICAL_I,
    @SerialName("REACTOR_ANTIMATTER_I") REACTOR_ANTIMATTER_I,
    @SerialName("ENGINE_IMPULSE_DRIVE_I") ENGINE_IMPULSE_DRIVE_I,
    @SerialName("ENGINE_ION_DRIVE_I") ENGINE_ION_DRIVE_I,
    @SerialName("ENGINE_ION_DRIVE_II") ENGINE_ION_DRIVE_II,
    @SerialName("ENGINE_HYPER_DRIVE_I") ENGINE_HYPER_DRIVE_I,
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
