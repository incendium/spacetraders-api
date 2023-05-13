package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class SystemType {
    @SerialName("NEUTRON_STAR") NEUTRON_STAR,
    @SerialName("RED_STAR") RED_STAR,
    @SerialName("ORANGE_STAR") ORANGE_STAR,
    @SerialName("BLUE_STAR") BLUE_STAR,
    @SerialName("YOUNG_STAR") YOUNG_STAR,
    @SerialName("WHITE_DWARF") WHITE_DWARF,
    @SerialName("BLACK_HOLE") BLACK_HOLE,
    @SerialName("HYPERGIANT") HYPERGIANT,
    @SerialName("NEBULA") NEBULA,
    @SerialName("UNSTABLE") UNSTABLE,
}
