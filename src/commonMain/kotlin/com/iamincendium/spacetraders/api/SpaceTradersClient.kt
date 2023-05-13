package com.iamincendium.spacetraders.api

import com.github.michaelbull.result.map
import com.iamincendium.spacetraders.api.client.AgentsClient
import com.iamincendium.spacetraders.api.client.ContractsClient
import com.iamincendium.spacetraders.api.client.DefaultClient
import com.iamincendium.spacetraders.api.client.FactionsClient
import com.iamincendium.spacetraders.api.client.FleetClient
import com.iamincendium.spacetraders.api.client.SystemsClient
import com.iamincendium.spacetraders.api.client.internal.RestClient
import com.iamincendium.spacetraders.api.client.internal.defaultHttpClient
import com.iamincendium.spacetraders.api.models.RegisterRequest
import com.iamincendium.spacetraders.api.models.Registration
import com.iamincendium.spacetraders.api.result.APIResult
import io.ktor.client.HttpClient

/**
 * A rate limit aware API client for the Space Traders API.
 */
public class SpaceTradersClient internal constructor(
    apiToken: String?,
    baseUrl: String,
    httpClient: HttpClient = defaultHttpClient(),
) {
    /**
     * Construct a new instance of this API client. This instance can only be used to register for a new API token.
     */
    private constructor() : this(null, BASE_URL)

    /**
     * Construct a new instance of this API client.
     *
     * @param apiToken the API token to use when interacting with the API
     */
    public constructor(apiToken: String) : this(apiToken, BASE_URL)

    private val restClient = RestClient(apiToken, baseUrl, httpClient)

    private val default: DefaultClient by lazy { DefaultClient(restClient) }
    public val agents: AgentsClient by lazy { AgentsClient(restClient) }
    public val contracts: ContractsClient by lazy { ContractsClient(restClient) }
    public val factions: FactionsClient by lazy { FactionsClient(restClient) }
    public val fleet: FleetClient by lazy { FleetClient(restClient) }
    public val systems: SystemsClient by lazy { SystemsClient(restClient) }

    public companion object {
        internal const val BASE_URL: String = "https://api.spacetraders.io/v2"

        /**
         * #### Register Agent
         *
         * Creates a new agent and ties it to a temporary account.
         *
         * The agent symbol is a 3-14 character string that will represent your agent. This symbol will prefix the
         * symbol of every ship you own. Agent symbols will be cast to all uppercase characters.
         *
         * A new agent will be granted an authorization token, a contract with their starting faction, a command ship
         * with a jump drive, and one hundred thousand credits.
         *
         * @param agentSymbol How other agents will see your ships and information.
         * @param faction The faction you choose determines your headquarters.
         */
        public suspend fun register(
            agentSymbol: String,
            faction: RegisterRequest.Faction,
        ): APIResult<Registration> {
            val client = SpaceTradersClient()
            return client.default.register(agentSymbol, faction).map { it.payload }
        }
    }
}
