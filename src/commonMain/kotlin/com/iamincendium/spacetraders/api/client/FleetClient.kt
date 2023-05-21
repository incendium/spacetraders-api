package com.iamincendium.spacetraders.api.client

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.map
import com.iamincendium.spacetraders.api.client.internal.RestClient
import com.iamincendium.spacetraders.api.client.internal.runRequiringToken
import com.iamincendium.spacetraders.api.client.internal.setPageParameters
import com.iamincendium.spacetraders.api.error.GenericHTTPError
import com.iamincendium.spacetraders.api.models.*
import com.iamincendium.spacetraders.api.result.APIResult
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.datetime.Clock

/**
 * API client for interacting with the `/my/ships` endpoint.
 */
@Suppress("TooManyFunctions")
public class FleetClient internal constructor(private val client: RestClient) {
    /**
     * #### List Ships
     *
     * Retrieve all of your ships.
     *
     * @param page What entry offset to request (optional)
     * @param limit How many entries to return per page (optional)
     */
    public suspend fun listShips(
        page: Int? = null,
        limit: Int? = null,
    ): APIResult<PagedResponse<List<Ship>>> = client.runRequiringToken {
        client.get("/my/ships") { setPageParameters(page, limit) }
            .map { it.body<PagedResponse<List<Ship>>>() }
    }

    /**
     * #### Purchase Ship
     *
     * Purchase a ship.
     *
     * @param purchaseShipRequest The request payload to send.
     */
    public suspend fun purchaseShip(
        purchaseShipRequest: PurchaseShipRequest,
    ): APIResult<Response<PurchaseShipResponse>> = client.runRequiringToken {
        client.post("/my/ships") { setBody(purchaseShipRequest) }
            .map { it.body<Response<PurchaseShipResponse>>() }
    }

    /**
     * #### Get Ship
     *
     * Retrieve the details of your ship.
     *
     * @param shipSymbol The symbol of the ship
     */
    public suspend fun getShip(shipSymbol: String): APIResult<Response<Ship>> = client.runRequiringToken {
        client.get("/my/ships/$shipSymbol").map { it.body<Response<Ship>>() }
    }

    /**
     * #### Get Ship Cargo
     *
     * Retrieve the cargo of your ship.
     *
     * @param shipSymbol The symbol of the ship
     */
    public suspend fun getShipCargo(
        shipSymbol: String,
    ): APIResult<Response<ShipCargo>> = client.runRequiringToken {
        client.get("/my/ships/$shipSymbol/cargo").map { it.body<Response<ShipCargo>>() }
    }

    /**
     * #### Orbit Ship
     *
     * Attempt to move your ship into orbit at it's current location. The request will only succeed if your ship is
     * capable of moving into orbit at the time of the request.
     *
     * The endpoint is idempotent - successive calls will succeed even if the ship is already in orbit.
     *
     * @param shipSymbol The symbol of the ship
     */
    public suspend fun orbitShip(
        shipSymbol: String,
    ): APIResult<Response<OrbitShipResponse>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/orbit").map { it.body<Response<OrbitShipResponse>>() }
    }

    /**
     * #### Ship Refine
     *
     * Attempt to refine the raw materials on your ship. The request will only succeed if your ship is capable of
     * refining at the time of the request.
     *
     * @param shipSymbol The symbol of the ship
     * @param shipRefineRequest The request payload to send.
     */
    public suspend fun shipRefine(
        shipSymbol: String,
        shipRefineRequest: ShipRefineRequest,
    ): APIResult<Response<ShipRefineResponse>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/refine") { setBody(shipRefineRequest) }
            .map { it.body<Response<ShipRefineResponse>>() }
    }

    /**
     * #### Create Chart
     *
     * Command a ship to chart the current waypoint.
     *
     * Waypoints in the universe are uncharted by default. These locations will not show up in the API until they have
     * been charted by a ship.
     *
     * Charting a location will record your agent as the one who created the chart.
     *
     * @param shipSymbol The symbol of the ship
     */
    public suspend fun createChart(
        shipSymbol: String,
    ): APIResult<Response<CreateChartResponse>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/chart")
            .map { it.body<Response<CreateChartResponse>>() }
    }

    /**
     * #### Get Ship Cooldown
     *
     * Retrieve the details of your ship's reactor cooldown. Some actions such as activating your jump drive, scanning,
     * or extracting resources taxes your reactor and results in a cooldown.
     *
     * Your ship cannot perform additional actions until your cooldown has expired. The duration of your cooldown is
     * relative to the power consumption of the related modules or mounts for the action taken.
     *
     * Response returns a 204 status code (no-content) when the ship has no cooldown.
     *
     * @param shipSymbol The symbol of the ship
     */
    public suspend fun getShipCooldown(
        shipSymbol: String,
    ): APIResult<Response<Cooldown>> = client.runRequiringToken {
        client.get("/my/ships/$shipSymbol/cooldown").map { response ->
            when (response.status) {
                HttpStatusCode.OK -> response.body<Response<Cooldown>>()
                HttpStatusCode.NoContent -> Response(Cooldown(shipSymbol, 0, 0, Clock.System.now()))
                else -> return Err(GenericHTTPError(response.status))
            }
        }
    }

    /**
     * #### Dock Ship
     *
     * Attempt to dock your ship at it's current location. Docking will only succeed if the waypoint is a dockable
     * location, and your ship is capable of docking at the time of the request.
     *
     * The endpoint is idempotent - successive calls will succeed even if the ship is already docked.
     *
     * @param shipSymbol The symbol of the ship
     */
    public suspend fun dockShip(shipSymbol: String): APIResult<Response<DockShipResponse>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/dock")
            .map { it.body<Response<DockShipResponse>>() }
    }

    /**
     * #### Create Survey
     *
     * If you want to target specific yields for an extraction, you can survey a waypoint, such as an asteroid field,
     * and send the survey in the body of the extract request. Each survey may have multiple deposits, and if a symbol
     * shows up more than once, that indicates a higher chance of extracting that resource.
     *
     * Your ship will enter a cooldown between consecutive survey requests. Surveys will eventually expire after a
     * period of time. Multiple ships can use the same survey for extraction.
     *
     * @param shipSymbol The symbol of the ship
     */
    public suspend fun createSurvey(
        shipSymbol: String,
    ): APIResult<Response<CreateSurveyResponse>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/survey")
            .map { it.body<Response<CreateSurveyResponse>>() }
    }

    /**
     * #### Extract Resources
     *
     * Extract resources from the waypoint into your ship. Send an optional survey as the payload to target specific
     * yields.
     *
     * @param shipSymbol The symbol of the ship
     * @param extractResourcesRequest The optional request payload to send.
     */
    public suspend fun extractResources(
        shipSymbol: String,
        extractResourcesRequest: ExtractResourcesRequest? = null,
    ): APIResult<Response<ExtractResourcesResponse>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/extract") {
            if (extractResourcesRequest != null) {
                setBody(extractResourcesRequest)
            }
        }.map { it.body<Response<ExtractResourcesResponse>>() }
    }

    /**
     * #### Jettison Cargo
     *
     * Jettison cargo from your ship's cargo hold.
     *
     * @param shipSymbol The symbol of the ship
     * @param jettisonRequest The request payload to send.
     */
    public suspend fun jettison(
        shipSymbol: String,
        jettisonRequest: JettisonRequest,
    ): APIResult<Response<JettisonResponse>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/jettison") { setBody(jettisonRequest) }
            .map { it.body<Response<JettisonResponse>>() }
    }

    /**
     * #### Jump Ship
     *
     * Jump your ship instantly to a target system. Unlike other forms of navigation, jumping requires a unit of
     * antimatter.
     *
     * @param shipSymbol The symbol of the ship
     * @param jumpShipRequest The request payload to send.
     */
    public suspend fun jumpShip(
        shipSymbol: String,
        jumpShipRequest: JumpShipRequest,
    ): APIResult<Response<JumpShipResponse>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/jump") { setBody(jumpShipRequest) }
            .map { it.body<Response<JumpShipResponse>>() }
    }

    /**
     * #### Navigate Ship
     *
     * Navigate to a target destination. The destination must be located within the same system as the ship. Navigating
     * will consume the necessary fuel and supplies from the ship's manifest, and will pay out crew wages from the
     * agent's account.
     *
     * The returned response will detail the route information including the expected time of arrival. Most ship actions
     * are unavailable until the ship has arrived at its destination.
     *
     * To travel between systems, see the ship's warp or jump actions.
     *
     * @param shipSymbol The symbol of the ship
     * @param navigateShipRequest The request payload to send.
     */
    public suspend fun navigateShip(
        shipSymbol: String,
        navigateShipRequest: NavigateShipRequest,
    ): APIResult<Response<NavigateShipResponse>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/navigate") { setBody(navigateShipRequest) }
            .map { it.body<Response<NavigateShipResponse>>() }
    }

    /**
     * #### Update Ship Nav
     *
     * Update the nav data of a ship, such as the flight mode.
     *
     * @param shipSymbol The symbol of the ship
     * @param updateShipNavRequest The request payload to send.
     */
    public suspend fun updateShipNav(
        shipSymbol: String,
        updateShipNavRequest: UpdateShipNavRequest,
    ): APIResult<Response<ShipNav>> = client.runRequiringToken {
        client.patch("/my/ships/$shipSymbol/nav") { setBody(updateShipNavRequest) }
            .map { it.body<Response<ShipNav>>() }
    }

    /**
     * #### Get Ship Nav
     *
     * Get the current nav status of a ship.
     *
     * @param shipSymbol The symbol of the ship
     */
    public suspend fun getShipNav(shipSymbol: String): APIResult<Response<ShipNav>> = client.runRequiringToken {
        client.get("/my/ships/$shipSymbol/nav").map { it.body<Response<ShipNav>>() }
    }

    /**
     * #### Warp Ship
     *
     * Warp your ship to a target destination in another system. Warping will consume the necessary fuel and supplies
     * from the ship's manifest, and will pay out crew wages from the agent's account.
     *
     * The returned response will detail the route information including the expected time of arrival. Most ship actions
     * are unavailable until the ship has arrived at it's destination.
     *
     * @param shipSymbol The symbol of the ship
     * @param navigateShipRequest The request payload to send.
     */
    public suspend fun warpShip(
        shipSymbol: String,
        navigateShipRequest: NavigateShipRequest,
    ): APIResult<Response<NavigateShipResponse>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/warp") { setBody(navigateShipRequest) }
            .map { it.body<Response<NavigateShipResponse>>() }
    }

    /**
     * #### Sell Cargo
     *
     * Sell cargo.
     *
     * @param shipSymbol The symbol of the ship
     * @param sellCargoRequest The request payload to send.
     */
    public suspend fun sellCargo(
        shipSymbol: String,
        sellCargoRequest: SellCargoRequest,
    ): APIResult<Response<CargoTransaction>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/sell") { setBody(sellCargoRequest) }
            .map { it.body<Response<CargoTransaction>>() }
    }

    /**
     * #### Scan Systems
     *
     * Activate your ship's sensor arrays to scan for system information.
     *
     * @param shipSymbol The symbol of the ship
     */
    public suspend fun scanSystems(
        shipSymbol: String,
    ): APIResult<Response<SystemScanResult>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/scan/systems").map { it.body<Response<SystemScanResult>>() }
    }

    /**
     * #### Scan Waypoints
     *
     * Activate your ship's sensor arrays to scan for waypoint information.
     *
     * @param shipSymbol The symbol of the ship
     */
    public suspend fun scanWaypoints(
        shipSymbol: String,
    ): APIResult<Response<WaypointScanResult>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/scan/waypoints").map { it.body<Response<WaypointScanResult>>() }
    }

    /**
     * #### Scan Ships
     *
     * Activate your ship's sensor arrays to scan for ship information.
     *
     * @param shipSymbol The symbol of the ship
     */
    public suspend fun scanShips(
        shipSymbol: String,
    ): APIResult<Response<ShipScanResult>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/scan/ships").map { it.body<Response<ShipScanResult>>() }
    }

    /**
     * #### Refuel Ship
     *
     * Refuel your ship from the local market.
     *
     * @param shipSymbol The symbol of the ship
     */
    public suspend fun refuelShip(
        shipSymbol: String,
    ): APIResult<Response<RefuelShipResponse>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/refuel").map { it.body<Response<RefuelShipResponse>>() }
    }

    /**
     * #### Purchase Cargo
     *
     * Purchase cargo.
     *
     * @param shipSymbol The symbol of the ship
     * @param purchaseCargoRequest The request payload to send.
     */
    public suspend fun purchaseCargo(
        shipSymbol: String,
        purchaseCargoRequest: PurchaseCargoRequest,
    ): APIResult<Response<CargoTransaction>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/purchase") { setBody(purchaseCargoRequest) }
            .map { it.body<Response<CargoTransaction>>() }
    }

    /**
     * #### Transfer Cargo
     *
     * Transfer cargo between ships.
     *
     * @param shipSymbol The symbol of the ship
     * @param transferCargoRequest The request payload to send.
     */
    public suspend fun transferCargo(
        shipSymbol: String,
        transferCargoRequest: TransferCargoRequest,
    ): APIResult<Response<CargoTransfer>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/transfer") { setBody(transferCargoRequest) }
            .map { it.body<Response<CargoTransfer>>() }
    }

    /**
     * #### Negotiate Contract
     *
     * Negotiate a new contract.
     *
     * @param shipSymbol The symbol of the ship
     */
    public suspend fun negotiateContract(
        shipSymbol: String,
    ): APIResult<Response<NegotiateContractResponse>> = client.runRequiringToken {
        client.post("/my/ships/$shipSymbol/negotiate/contract")
            .map { it.body<Response<NegotiateContractResponse>>() }
    }
}
