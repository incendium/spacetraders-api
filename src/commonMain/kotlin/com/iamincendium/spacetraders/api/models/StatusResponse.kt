package com.iamincendium.spacetraders.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class StatusResponse(
    @SerialName("status") val status: String,
    @SerialName("version") val version: String,
    @SerialName("resetDate") val resetDate: String,
    @SerialName("description") val description: String,
    @SerialName("stats") val stats: Stats,
    @SerialName("leaderboards") val leaderboards: Leaderboards,
    @SerialName("serverResets") val serverResets: ServerResets,
    @SerialName("announcements") val announcements: List<Announcement>,
    @SerialName("links") val links: List<Link>,
) {
    @Serializable
    public data class Stats(
        @SerialName("agents") val agents: Int,
        @SerialName("ships") val ships: Int,
        @SerialName("systems") val systems: Int,
        @SerialName("waypoints") val waypoints: Int,
    )

    @Serializable
    public data class Leaderboards(
        @SerialName("mostCredits") val mostCredits: List<MostCreditsEntry>,
        @SerialName("mostSubmittedCharts") val mostSubmittedCharts: List<MostSubmittedChartsEntry>,
    ) {
        @Serializable
        public data class MostCreditsEntry(
            @SerialName("agentSymbol") val agentSymbol: String,
            @SerialName("credits") val credits: Int,
        )

        @Serializable
        public data class MostSubmittedChartsEntry(
            @SerialName("agentSymbol") val agentSymbol: String,
            @SerialName("chartCount") val chartCount: Int,
        )
    }

    @Serializable
    public data class ServerResets(
        @SerialName("next") val next: String,
        @SerialName("frequency") val frequency: String,
    )

    @Serializable
    public data class Announcement(
        @SerialName("title") val title: String,
        @SerialName("body") val body: String,
    )

    @Serializable
    public data class Link(
        @SerialName("name") val name: String,
        @SerialName("url") val url: String,
    )
}
