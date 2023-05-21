package com.iamincendium.spacetraders.api.client

import com.github.michaelbull.result.map
import com.iamincendium.spacetraders.api.client.internal.RestClient
import com.iamincendium.spacetraders.api.models.StatusResponse
import com.iamincendium.spacetraders.api.result.APIResult
import com.iamincendium.spacetraders.api.util.runOrErrorAndFlatten
import io.ktor.client.call.*

/**
 * API client for interacting with the top-level API endpoint.
 */
public class DefaultClient internal constructor(private val client: RestClient) {
    /**
     * #### Get Status
     *
     * Return the status of the game server.
     */
    public suspend fun status(): APIResult<StatusResponse> = runOrErrorAndFlatten {
        client.get("/").map { it.body<StatusResponse>() }
    }
}
