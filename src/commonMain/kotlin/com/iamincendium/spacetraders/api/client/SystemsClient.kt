package com.iamincendium.spacetraders.api.client

import com.github.michaelbull.result.map
import com.iamincendium.spacetraders.api.client.internal.RestClient
import com.iamincendium.spacetraders.api.client.internal.runRequiringToken
import com.iamincendium.spacetraders.api.client.internal.setPageParameters
import com.iamincendium.spacetraders.api.models.JumpGate
import com.iamincendium.spacetraders.api.models.Market
import com.iamincendium.spacetraders.api.models.PagedResponse
import com.iamincendium.spacetraders.api.models.Response
import com.iamincendium.spacetraders.api.models.Shipyard
import com.iamincendium.spacetraders.api.models.System
import com.iamincendium.spacetraders.api.models.Waypoint
import com.iamincendium.spacetraders.api.result.APIResult
import io.ktor.client.call.*

/**
 * API client for interacting with the `/systems` endpoint.
 */
public class SystemsClient internal constructor(private val client: RestClient) {
    /**
     * #### List Systems
     *
     * Return a list of all systems.
     *
     * @param page What entry offset to request (optional)
     * @param limit How many entries to return per page (optional)
     */
    public suspend fun listSystems(
        page: Int? = null,
        limit: Int? = null,
    ): APIResult<PagedResponse<List<System>>> = client.runRequiringToken {
        client.get("/systems") { setPageParameters(page, limit) }
            .map { it.body<PagedResponse<List<System>>>() }
    }

    /**
     * #### Get System
     *
     * Get the details of a system.
     *
     * @param systemSymbol The system symbol
     */
    public suspend fun getSystem(systemSymbol: String): APIResult<Response<System>> = client.runRequiringToken {
        client.get("/systems/$systemSymbol").map { it.body<Response<System>>() }
    }

    /**
     * #### List Waypoints
     *
     * Fetch all of the waypoints for a given system. System must be charted or a ship must be present to return
     * waypoint details.
     *
     * @param systemSymbol The system symbol
     * @param page What entry offset to request (optional)
     * @param limit How many entries to return per page (optional)
     */
    public suspend fun listWaypoints(
        systemSymbol: String,
        page: Int? = null,
        limit: Int? = null,
    ): APIResult<PagedResponse<List<Waypoint>>> = client.runRequiringToken {
        client.get("/systems/$systemSymbol/waypoints") { setPageParameters(page, limit) }
            .map { it.body<PagedResponse<List<Waypoint>>>() }
    }

    /**
     * #### Get Waypoint
     *
     * View the details of a waypoint.
     *
     * @param systemSymbol The system symbol
     * @param waypointSymbol The waypoint symbol
     */
    public suspend fun getWaypoint(
        systemSymbol: String,
        waypointSymbol: String,
    ): APIResult<Response<Waypoint>> = client.runRequiringToken {
        client.get("/systems/$systemSymbol/waypoints/$waypointSymbol").map { it.body<Response<Waypoint>>() }
    }

    /**
     * #### Get Market
     * Retrieve imports, exports and exchange data from a marketplace. Imports can be sold, exports can be purchased,
     * and exchange goods can be purchased or sold. Send a ship to the waypoint to access trade good prices and recent
     * transactions.
     *
     * @param systemSymbol The system symbol
     * @param waypointSymbol The waypoint symbol
     */
    public suspend fun getMarket(
        systemSymbol: String,
        waypointSymbol: String,
    ): APIResult<Response<Market>> = client.runRequiringToken {
        client.get("/systems/$systemSymbol/waypoints/$waypointSymbol/market").map { it.body<Response<Market>>() }
    }

    /**
     * #### Get Shipyard
     *
     * Get the shipyard for a waypoint. Send a ship to the waypoint to access ships that are currently available for purchase and recent transactions.
     *
     * @param systemSymbol The system symbol
     * @param waypointSymbol The waypoint symbol
     */
    public suspend fun getShipyard(
        systemSymbol: String,
        waypointSymbol: String,
    ): APIResult<Response<Shipyard>> = client.runRequiringToken {
        client.get("/systems/$systemSymbol/waypoints/$waypointSymbol/shipyard")
            .map { it.body<Response<Shipyard>>() }
    }

    /**
     * #### Get Jump Gate
     *
     * Get jump gate details for a waypoint.
     *
     * @param systemSymbol The system symbol
     * @param waypointSymbol The waypoint symbol
     */
    public suspend fun getJumpGate(
        systemSymbol: String,
        waypointSymbol: String,
    ): APIResult<Response<JumpGate>> = client.runRequiringToken {
        client.get("/systems/$systemSymbol/waypoints/$waypointSymbol/jump-gate")
            .map { it.body<Response<JumpGate>>() }
    }
}
