package com.iamincendium.spacetraders.api.client

import assertk.assertThat
import com.iamincendium.spacetraders.api.models.AcceptedContract
import com.iamincendium.spacetraders.api.models.Agent
import com.iamincendium.spacetraders.api.models.Contract
import com.iamincendium.spacetraders.api.models.ContractDeliverGood
import com.iamincendium.spacetraders.api.models.ContractPayment
import com.iamincendium.spacetraders.api.models.ContractTerms
import com.iamincendium.spacetraders.api.models.DeliveredContract
import com.iamincendium.spacetraders.api.models.FulfilledContract
import com.iamincendium.spacetraders.api.models.PageData
import com.iamincendium.spacetraders.api.models.ShipCargo
import com.iamincendium.spacetraders.api.models.ShipCargoItem
import com.iamincendium.spacetraders.api.test.common.isValidPagedResponse
import com.iamincendium.spacetraders.api.test.common.isValidResponse
import com.iamincendium.spacetraders.api.test.common.mockApiClient
import io.kotest.core.spec.style.FunSpec
import kotlinx.datetime.Instant

class ContractsClientTest : FunSpec({
    test("listContracts - should handle the example data") {
        val response = """
            {
                "data": [
                    {
                        "id": "string",
                        "factionSymbol": "string",
                        "type": "PROCUREMENT",
                        "terms": {
                            "deadline": "2019-08-24T14:15:22Z",
                            "payment": {
                                "onAccepted": 0,
                                "onFulfilled": 0
                            },
                            "deliver": [
                                {
                                    "tradeSymbol": "string",
                                    "destinationSymbol": "string",
                                    "unitsRequired": 0,
                                    "unitsFulfilled": 0
                                }
                            ]
                        },
                        "accepted": false,
                        "fulfilled": false,
                        "expiration": "2019-08-24T14:15:22Z"
                    }
                ],
                "meta": {
                    "total": 0,
                    "page": 0,
                    "limit": 0
                }
            }
        """.trimIndent()

        val api = mockApiClient("/my/contracts", response)

        assertThat(api.contracts.listContracts()).isValidPagedResponse(
            listOf(Contract(
                id = "string",
                factionSymbol = "string",
                type = Contract.Type.PROCUREMENT,
                terms = ContractTerms(
                    deadline = Instant.parse("2019-08-24T14:15:22Z"),
                    payment = ContractPayment(0, 0),
                    deliver = listOf(
                        ContractDeliverGood(
                            tradeSymbol = "string",
                            destinationSymbol = "string",
                            unitsRequired = 0,
                            unitsFulfilled = 0,
                        ),
                    ),
                ),
                accepted = false,
                fulfilled = false,
                expiration = Instant.parse("2019-08-24T14:15:22Z"),
            )),
            PageData(0, 0, 0),
        )
    }

    test("getContract - should handle the example data") {
        val response = """
            {
                "data": {
                    "id": "string",
                    "factionSymbol": "string",
                    "type": "PROCUREMENT",
                    "terms": {
                        "deadline": "2019-08-24T14:15:22Z",
                        "payment": {
                            "onAccepted": 0,
                            "onFulfilled": 0
                        },
                        "deliver": [
                            {
                                "tradeSymbol": "string",
                                "destinationSymbol": "string",
                                "unitsRequired": 0,
                                "unitsFulfilled": 0
                            }
                        ]
                    },
                    "accepted": false,
                    "fulfilled": false,
                    "expiration": "2019-08-24T14:15:22Z"
                }
            }
        """.trimIndent()

        val api = mockApiClient("/my/contracts/string", response)

        assertThat(api.contracts.getContract("string")).isValidResponse(
            Contract(
                id = "string",
                factionSymbol = "string",
                type = Contract.Type.PROCUREMENT,
                terms = ContractTerms(
                    deadline = Instant.parse("2019-08-24T14:15:22Z"),
                    payment = ContractPayment(0, 0),
                    deliver = listOf(
                        ContractDeliverGood(
                            tradeSymbol = "string",
                            destinationSymbol = "string",
                            unitsRequired = 0,
                            unitsFulfilled = 0,
                        ),
                    ),
                ),
                accepted = false,
                fulfilled = false,
                expiration = Instant.parse("2019-08-24T14:15:22Z"),
            ),
        )
    }

    test("acceptContract - should handle the example data") {
        val response = """
            {
                "data": {
                    "agent": {
                        "accountId": "string",
                        "symbol": "string",
                        "headquarters": "string",
                        "credits": 0
                    },
                    "contract": {
                        "id": "string",
                        "factionSymbol": "string",
                        "type": "PROCUREMENT",
                        "terms": {
                            "deadline": "2019-08-24T14:15:22Z",
                            "payment": {
                                "onAccepted": 0,
                                "onFulfilled": 0
                            },
                            "deliver": [
                                {
                                    "tradeSymbol": "string",
                                    "destinationSymbol": "string",
                                    "unitsRequired": 0,
                                    "unitsFulfilled": 0
                                }
                            ]
                        },
                        "accepted": false,
                        "fulfilled": false,
                        "expiration": "2019-08-24T14:15:22Z"
                    }
                }
            }
        """.trimIndent()

        val api = mockApiClient("/my/contracts/string/accept", response)

        assertThat(api.contracts.acceptContract("string")).isValidResponse(
            AcceptedContract(
                agent = Agent(
                    accountId = "string",
                    symbol = "string",
                    headquarters = "string",
                    credits = 0,
                ),
                contract = Contract(
                    id = "string",
                    factionSymbol = "string",
                    type = Contract.Type.PROCUREMENT,
                    terms = ContractTerms(
                        deadline = Instant.parse("2019-08-24T14:15:22Z"),
                        payment = ContractPayment(0, 0),
                        deliver = listOf(
                            ContractDeliverGood(
                                tradeSymbol = "string",
                                destinationSymbol = "string",
                                unitsRequired = 0,
                                unitsFulfilled = 0,
                            ),
                        ),
                    ),
                    accepted = false,
                    fulfilled = false,
                    expiration = Instant.parse("2019-08-24T14:15:22Z"),
                ),
            ),
        )
    }

    test("deliverContract - should handle the example data") {
        val response = """
            {
                "data": {
                    "contract": {
                        "id": "string",
                        "factionSymbol": "string",
                        "type": "PROCUREMENT",
                        "terms": {
                            "deadline": "2019-08-24T14:15:22Z",
                            "payment": {
                                "onAccepted": 0,
                                "onFulfilled": 0
                            },
                            "deliver": [
                                {
                                    "tradeSymbol": "string",
                                    "destinationSymbol": "string",
                                    "unitsRequired": 0,
                                    "unitsFulfilled": 0
                                }
                            ]
                        },
                        "accepted": false,
                        "fulfilled": false,
                        "expiration": "2019-08-24T14:15:22Z"
                    },
                    "cargo": {
                        "capacity": 0,
                        "units": 0,
                        "inventory": [
                            {
                                "symbol": "string",
                                "name": "string",
                                "description": "string",
                                "units": 1
                            }
                        ]
                    }
                }
            }
        """.trimIndent()

        val api = mockApiClient("/my/contracts/string/deliver", response)

        assertThat(api.contracts.deliverContract("string")).isValidResponse(
            DeliveredContract(
                contract = Contract(
                    id = "string",
                    factionSymbol = "string",
                    type = Contract.Type.PROCUREMENT,
                    terms = ContractTerms(
                        deadline = Instant.parse("2019-08-24T14:15:22Z"),
                        payment = ContractPayment(0, 0),
                        deliver = listOf(
                            ContractDeliverGood(
                                tradeSymbol = "string",
                                destinationSymbol = "string",
                                unitsRequired = 0,
                                unitsFulfilled = 0,
                            ),
                        ),
                    ),
                    accepted = false,
                    fulfilled = false,
                    expiration = Instant.parse("2019-08-24T14:15:22Z"),
                ),
                cargo = ShipCargo(
                    capacity = 0,
                    units = 0,
                    inventory = listOf(
                        ShipCargoItem(
                            symbol = "string",
                            name = "string",
                            description = "string",
                            units = 1,
                        ),
                    ),
                ),
            ),
        )
    }

    test("fulfillContract - should handle the example data") {
        val response = """
            {
                "data": {
                    "agent": {
                        "accountId": "string",
                        "symbol": "string",
                        "headquarters": "string",
                        "credits": 0
                    },
                    "contract": {
                        "id": "string",
                        "factionSymbol": "string",
                        "type": "PROCUREMENT",
                        "terms": {
                            "deadline": "2019-08-24T14:15:22Z",
                            "payment": {
                                "onAccepted": 0,
                                "onFulfilled": 0
                            },
                            "deliver": [
                                {
                                    "tradeSymbol": "string",
                                    "destinationSymbol": "string",
                                    "unitsRequired": 0,
                                    "unitsFulfilled": 0
                                }
                            ]
                        },
                        "accepted": false,
                        "fulfilled": false,
                        "expiration": "2019-08-24T14:15:22Z"
                    }
                }
            }
        """.trimIndent()

        val api = mockApiClient("/my/contracts/string/fulfill", response)

        assertThat(api.contracts.fulfillContract("string")).isValidResponse(
            FulfilledContract(
                agent = Agent(
                    accountId = "string",
                    symbol = "string",
                    headquarters = "string",
                    credits = 0,
                ),
                contract = Contract(
                    id = "string",
                    factionSymbol = "string",
                    type = Contract.Type.PROCUREMENT,
                    terms = ContractTerms(
                        deadline = Instant.parse("2019-08-24T14:15:22Z"),
                        payment = ContractPayment(0, 0),
                        deliver = listOf(
                            ContractDeliverGood(
                                tradeSymbol = "string",
                                destinationSymbol = "string",
                                unitsRequired = 0,
                                unitsFulfilled = 0,
                            ),
                        ),
                    ),
                    accepted = false,
                    fulfilled = false,
                    expiration = Instant.parse("2019-08-24T14:15:22Z"),
                ),
            ),
        )
    }
})
