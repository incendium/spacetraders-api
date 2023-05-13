package com.iamincendium.spacetraders.api.models

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ShipEngine(
    @SerialName("symbol") val symbol: Symbol,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String,
    @SerialName("speed") @Contextual val speed: BigDecimal,
    @SerialName("requirements") val requirements: ShipRequirements,
    @SerialName("condition") val condition: Int? = null,
) {
    @Serializable
    public enum class Symbol {
        @SerialName("ENGINE_IMPULSE_DRIVE_I") ENGINE_IMPULSE_DRIVE_I,
        @SerialName("ENGINE_ION_DRIVE_I") ENGINE_ION_DRIVE_I,
        @SerialName("ENGINE_ION_DRIVE_II") ENGINE_ION_DRIVE_II,
        @SerialName("ENGINE_HYPER_DRIVE_I") ENGINE_HYPER_DRIVE_I,
    }
}
