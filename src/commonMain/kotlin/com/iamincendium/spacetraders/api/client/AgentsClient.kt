package com.iamincendium.spacetraders.api.client

import com.github.michaelbull.result.map
import com.iamincendium.spacetraders.api.result.APIResult
import com.iamincendium.spacetraders.api.client.internal.RestClient
import com.iamincendium.spacetraders.api.client.internal.runRequiringToken
import com.iamincendium.spacetraders.api.models.Agent
import com.iamincendium.spacetraders.api.models.Response
import io.ktor.client.call.*

/**
 * API client for interacting with the `/my/agent` endpoint.
 */
public class AgentsClient internal constructor(private val client: RestClient) {
    /**
     * #### My Agent Details
     *
     * Fetch your agent's details.
     */
    public suspend fun getMyAgent(): APIResult<Response<Agent>> = client.runRequiringToken {
        client.get("/my/agent").map { it.body<Response<Agent>>() }
    }
}
