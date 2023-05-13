package com.iamincendium.spacetraders.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Contract(
    @SerialName("id") val id: String,
    @SerialName("factionSymbol") val factionSymbol: String,
    @SerialName("type") val type: Type,
    @SerialName("terms") val terms: ContractTerms,
    @SerialName("accepted") val accepted: Boolean = false,
    @SerialName("fulfilled") val fulfilled: Boolean = false,
    @SerialName("expiration") val expiration: Instant,
) {
    @Serializable
    public enum class Type {
        @SerialName("PROCUREMENT") PROCUREMENT,
        @SerialName("TRANSPORT") TRANSPORT,
        @SerialName("SHUTTLE") SHUTTLE,
    }
}
