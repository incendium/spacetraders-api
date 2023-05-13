package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PagedResponse<T : Any>(
    @SerialName("data") val payload: T,
    @SerialName("meta") val pageData: PageData,
)
