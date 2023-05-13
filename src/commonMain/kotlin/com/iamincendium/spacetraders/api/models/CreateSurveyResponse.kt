package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class CreateSurveyResponse(
    @SerialName("cooldown") val cooldown: Cooldown,
    @SerialName("surveys") val surveys: List<Survey>,
)
