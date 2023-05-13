package com.iamincendium.spacetraders.api.client

import com.github.michaelbull.result.map
import com.iamincendium.spacetraders.api.result.APIResult
import com.iamincendium.spacetraders.api.client.internal.RestClient
import com.iamincendium.spacetraders.api.models.RegisterRequest
import com.iamincendium.spacetraders.api.models.Registration
import com.iamincendium.spacetraders.api.models.Response
import com.iamincendium.spacetraders.api.util.runOrErrorAndFlatten
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * API client for interacting with the top-level API endpoint.
 */
public class DefaultClient internal constructor(private val client: RestClient) {
    /**
     * #### Register Agent
     *
     * Creates a new agent and ties it to a temporary account.
     *
     * The agent symbol is a 3-14 character string that will represent your agent. This symbol will prefix the symbol
     * of every ship you own. Agent symbols will be cast to all uppercase characters.
     *
     * A new agent will be granted an authorization token, a contract with their starting faction, a command ship with
     * a jump drive, and one hundred thousand credits.
     *
     * @param agentSymbol How other agents will see your ships and information.
     * @param faction The faction you choose determines your headquarters.
     */
    public suspend fun register(
        agentSymbol: String,
        faction: RegisterRequest.Faction,
    ): APIResult<Response<Registration>> = runOrErrorAndFlatten {
        client.post("/register") { setBody(RegisterRequest(faction, agentSymbol)) }
            .map { it.body<Response<Registration>>() }
    }
}
