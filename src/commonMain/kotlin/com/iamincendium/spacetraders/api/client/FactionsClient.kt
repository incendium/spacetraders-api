package com.iamincendium.spacetraders.api.client

import com.github.michaelbull.result.map
import com.iamincendium.spacetraders.api.client.internal.RestClient
import com.iamincendium.spacetraders.api.client.internal.runRequiringToken
import com.iamincendium.spacetraders.api.client.internal.setPageParameters
import com.iamincendium.spacetraders.api.models.Faction
import com.iamincendium.spacetraders.api.models.PagedResponse
import com.iamincendium.spacetraders.api.models.Response
import com.iamincendium.spacetraders.api.result.APIResult
import io.ktor.client.call.*

/**
 * API client for interacting with the `/factions` endpoint.
 */
public class FactionsClient internal constructor(private val client: RestClient) {
    /**
     * #### List Factions
     *
     * List all discovered factions in the game.
     *
     * @param page What entry offset to request (optional)
     * @param limit How many entries to return per page (optional)
     */
    public suspend fun listFactions(
        page: Int? = null,
        limit: Int? = null,
    ): APIResult<PagedResponse<List<Faction>>> = client.runRequiringToken {
        client.get("/factions") { setPageParameters(page, limit) }
            .map { it.body<PagedResponse<List<Faction>>>() }
    }

    /**
     * #### Get Faction
     *
     * View the details of a faction.
     *
     * @param factionSymbol The faction symbol
     */
    public suspend fun getFaction(factionSymbol: String): APIResult<Response<Faction>> = client.runRequiringToken {
        client.get("/factions/$factionSymbol")
            .map { it.body<Response<Faction>>() }
    }
}
