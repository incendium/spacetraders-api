package com.iamincendium.spacetraders.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Chart(
    @SerialName("waypointSymbol") val waypointSymbol: String? = null,
    @SerialName("submittedBy") val submittedBy: String? = null,
    @SerialName("submittedOn") val submittedOn: Instant? = null,
)
