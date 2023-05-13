package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RegisterRequest(
    @SerialName("faction") val faction: Faction,
    @SerialName("symbol") val symbol: String,
) {
    @Serializable
    public enum class Faction {
        @SerialName("COSMIC") COSMIC,
        @SerialName("VOID") VOID,
        @SerialName("GALACTIC") GALACTIC,
        @SerialName("QUANTUM") QUANTUM,
        @SerialName("DOMINION") DOMINION,
    }
}
