package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ShipRole {
    @SerialName("FABRICATOR") FABRICATOR,
    @SerialName("HARVESTER") HARVESTER,
    @SerialName("HAULER") HAULER,
    @SerialName("INTERCEPTOR") INTERCEPTOR,
    @SerialName("EXCAVATOR") EXCAVATOR,
    @SerialName("TRANSPORT") TRANSPORT,
    @SerialName("REPAIR") REPAIR,
    @SerialName("SURVEYOR") SURVEYOR,
    @SerialName("COMMAND") COMMAND,
    @SerialName("CARRIER") CARRIER,
    @SerialName("PATROL") PATROL,
    @SerialName("SATELLITE") SATELLITE,
    @SerialName("EXPLORER") EXPLORER,
    @SerialName("REFINERY") REFINERY,
}
