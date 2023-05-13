package com.iamincendium.spacetraders.api.client

import com.github.michaelbull.result.map
import com.iamincendium.spacetraders.api.result.APIResult
import com.iamincendium.spacetraders.api.client.internal.RestClient
import com.iamincendium.spacetraders.api.client.internal.runRequiringToken
import com.iamincendium.spacetraders.api.client.internal.setPageParameters
import com.iamincendium.spacetraders.api.models.DeliverContractRequest
import com.iamincendium.spacetraders.api.models.AcceptedContract
import com.iamincendium.spacetraders.api.models.Contract
import com.iamincendium.spacetraders.api.models.DeliveredContract
import com.iamincendium.spacetraders.api.models.FulfilledContract
import com.iamincendium.spacetraders.api.models.PagedResponse
import com.iamincendium.spacetraders.api.models.Response
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * API client for interacting with the `/my/contracts` endpoint.
 */
public class ContractsClient internal constructor(private val client: RestClient) {
    /**
     * #### List Contracts
     *
     * List all of your contracts.
     *
     * @param page What entry offset to request (optional)
     * @param limit How many entries to return per page (optional)
     */
    public suspend fun listContracts(
        page: Int? = null,
        limit: Int? = null,
    ): APIResult<PagedResponse<List<Contract>>> = client.runRequiringToken {
        client.get("/my/contracts") { setPageParameters(page, limit) }
            .map { it.body<PagedResponse<List<Contract>>>() }
    }

    /**
     * #### Get Contract
     *
     * Get the details of a contract by ID.
     *
     * @param contractId The contract ID
     */
    public suspend fun getContract(contractId: String): APIResult<Response<Contract>> = client.runRequiringToken {
        client.get("/my/contracts/$contractId")
            .map { it.body<Response<Contract>>() }
    }

    /**
     * #### Accept Contract
     *
     * Accept a contract.
     *
     * @param contractId The contract id
     */
    public suspend fun acceptContract(
        contractId: String,
    ): APIResult<Response<AcceptedContract>> = client.runRequiringToken {
        client.post("/my/contracts/$contractId/accept")
            .map { it.body<Response<AcceptedContract>>() }
    }

    /**
     * #### Deliver Contract
     *
     * Deliver cargo on a given contract.
     *
     * @param contractId The ID of the contract
     * @param deliverContractRequest  (optional)
     */
    public suspend fun deliverContract(
        contractId: String,
        deliverContractRequest: DeliverContractRequest? = null,
    ): APIResult<Response<DeliveredContract>> = client.runRequiringToken {
        client.post("/my/contracts/$contractId/deliver") {
            if (deliverContractRequest != null) {
                setBody(deliverContractRequest)
            }
        }.map { it.body<Response<DeliveredContract>>() }
    }

    /**
     * #### Fulfill Contract
     *
     * Fulfill a contract.
     *
     * @param contractId The ID of the contract
     */
    public suspend fun fulfillContract(
        contractId: String,
    ): APIResult<Response<FulfilledContract>> = client.runRequiringToken {
        client.post("/my/contracts/$contractId/fulfill")
            .map { it.body<Response<FulfilledContract>>() }
    }
}
