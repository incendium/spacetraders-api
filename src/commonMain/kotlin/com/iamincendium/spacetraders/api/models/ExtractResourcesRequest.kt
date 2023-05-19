package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Request payload sent when extracting resources.
 *
 * @param survey An optional survey to use to target specific resources.
 */
@Serializable
public data class ExtractResourcesRequest(
    @SerialName("survey") val survey: Survey? = null,
)
