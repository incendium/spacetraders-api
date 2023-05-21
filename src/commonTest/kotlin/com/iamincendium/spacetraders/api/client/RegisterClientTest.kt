package com.iamincendium.spacetraders.api.client

import assertk.assertThat
import com.iamincendium.spacetraders.api.SpaceTradersAPI
import com.iamincendium.spacetraders.api.client.internal.RestClient
import com.iamincendium.spacetraders.api.models.*
import com.iamincendium.spacetraders.api.test.common.isValidResponse
import com.iamincendium.spacetraders.api.test.common.mockApiResponse
import io.kotest.core.spec.style.FunSpec
import io.ktor.http.*
import kotlinx.datetime.Instant

class RegisterClientTest : FunSpec({
    test("register - should handle the example data") {
        val response = """
            {
                "data": {
                    "agent": {
                        "accountId": "string",
                        "symbol": "string",
                        "headquarters": "string",
                        "credits": 0,
                        "startingFaction": "string"
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
                        "expiration": "2019-08-24T14:15:22Z",
                        "deadlineToAccept": "2019-08-24T14:15:22Z"
                    },
                    "faction": {
                        "symbol": "string",
                        "name": "string",
                        "description": "string",
                        "headquarters": "string",
                        "traits": [
                            {
                                "symbol": "BUREAUCRATIC",
                                "name": "string",
                                "description": "string"
                            }
                        ],
                        "isRecruiting": true
                    },
                    "ship": {
                        "symbol": "string",
                        "registration": {
                            "name": "string",
                            "factionSymbol": "string",
                            "role": "FABRICATOR"
                        },
                        "nav": {
                            "systemSymbol": "string",
                            "waypointSymbol": "string",
                            "route": {
                                "destination": {
                                    "symbol": "string",
                                    "type": "PLANET",
                                    "systemSymbol": "string",
                                    "x": 0,
                                    "y": 0
                                },
                                "departure": {
                                    "symbol": "string",
                                    "type": "PLANET",
                                    "systemSymbol": "string",
                                    "x": 0,
                                    "y": 0
                                },
                                "departureTime": "2019-08-24T14:15:22Z",
                                "arrival": "2019-08-24T14:15:22Z"
                            },
                            "status": "IN_TRANSIT",
                            "flightMode": "CRUISE"
                        },
                        "crew": {
                            "current": 0,
                            "required": 0,
                            "capacity": 0,
                            "rotation": "STRICT",
                            "morale": 0,
                            "wages": 0
                        },
                        "frame": {
                            "symbol": "FRAME_PROBE",
                            "name": "string",
                            "description": "string",
                            "condition": 0,
                            "moduleSlots": 0,
                            "mountingPoints": 0,
                            "fuelCapacity": 0,
                            "requirements": {
                                "power": 0,
                                "crew": 0,
                                "slots": 0
                            }
                        },
                        "reactor": {
                            "symbol": "REACTOR_SOLAR_I",
                            "name": "string",
                            "description": "string",
                            "condition": 0,
                            "powerOutput": 1,
                            "requirements": {
                                "power": 0,
                                "crew": 0,
                                "slots": 0
                            }
                        },
                        "engine": {
                            "symbol": "ENGINE_IMPULSE_DRIVE_I",
                            "name": "string",
                            "description": "string",
                            "condition": 0,
                            "speed": 1,
                            "requirements": {
                                "power": 0,
                                "crew": 0,
                                "slots": 0
                            }
                        },
                        "modules": [
                            {
                                "symbol": "MODULE_MINERAL_PROCESSOR_I",
                                "capacity": 0,
                                "range": 0,
                                "name": "string",
                                "description": "string",
                                "requirements": {
                                    "power": 0,
                                    "crew": 0,
                                    "slots": 0
                                }
                            }
                        ],
                        "mounts": [
                            {
                                "symbol": "MOUNT_GAS_SIPHON_I",
                                "name": "string",
                                "description": "string",
                                "strength": 0,
                                "deposits": [
                                    "QUARTZ_SAND"
                                ],
                                "requirements": {
                                    "power": 0,
                                    "crew": 0,
                                    "slots": 0
                                }
                            }
                        ],
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
                        },
                        "fuel": {
                            "current": 0,
                            "capacity": 0,
                            "consumed": {
                                "amount": 0,
                                "timestamp": "2019-08-24T14:15:22Z"
                            }
                        }
                    },
                    "token": "string"
                }
            }
        """.trimIndent()

        val baseUrl = SpaceTradersAPI.BASE_URL
        val httpClient = mockApiResponse(HttpMethod.Post, "$baseUrl/register", response)
        val restClient = RestClient("dummy-token", baseUrl, httpClient)
        val registerClient = RegisterClient(restClient)

        assertThat(registerClient.register("string", RegisterRequest.Faction.COSMIC, null)).isValidResponse(
            Registration(
                agent = Agent(
                    accountId = "string",
                    symbol = "string",
                    headquarters = "string",
                    credits = 0,
                    startingFaction = "string",
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
                    deadlineToAccept = Instant.parse("2019-08-24T14:15:22Z"),
                ),
                faction = Faction(
                    symbol = "string",
                    name = "string",
                    description = "string",
                    headquarters = "string",
                    traits = listOf(
                        FactionTrait(
                            symbol = FactionTrait.Symbol.BUREAUCRATIC,
                            name = "string",
                            description = "string",
                        )
                    ),
                    isRecruiting = true,
                ),
                ship = Ship(
                    symbol = "string",
                    registration = ShipRegistration(
                        name = "string",
                        factionSymbol = "string",
                        role = ShipRole.FABRICATOR,
                    ),
                    nav = ShipNav(
                        systemSymbol = "string",
                        waypointSymbol = "string",
                        route = ShipNavRoute(
                            destination = ShipNavRouteWaypoint(
                                symbol = "string",
                                type = WaypointType.PLANET,
                                systemSymbol = "string",
                                x = 0,
                                y = 0,
                            ),
                            departure = ShipNavRouteWaypoint(
                                symbol = "string",
                                type = WaypointType.PLANET,
                                systemSymbol = "string",
                                x = 0,
                                y = 0,
                            ),
                            departureTime = Instant.parse("2019-08-24T14:15:22Z"),
                            arrival = Instant.parse("2019-08-24T14:15:22Z"),
                        ),
                        status = ShipNavStatus.IN_TRANSIT,
                        flightMode = ShipNavFlightMode.CRUISE,
                    ),
                    crew = ShipCrew(
                        current = 0,
                        required = 0,
                        capacity = 0,
                        rotation = ShipCrew.Rotation.STRICT,
                        morale = 0,
                        wages = 0,
                    ),
                    frame = ShipFrame(
                        symbol = ShipFrame.Symbol.FRAME_PROBE,
                        name = "string",
                        description = "string",
                        condition = 0,
                        moduleSlots = 0,
                        mountingPoints = 0,
                        fuelCapacity = 0,
                        requirements = ShipRequirements(
                            power = 0,
                            crew = 0,
                            slots = 0,
                        ),
                    ),
                    reactor = ShipReactor(
                        symbol = ShipReactor.Symbol.REACTOR_SOLAR_I,
                        name = "string",
                        description = "string",
                        condition = 0,
                        powerOutput = 1,
                        requirements = ShipRequirements(
                            power = 0,
                            crew = 0,
                            slots = 0,
                        ),
                    ),
                    engine = ShipEngine(
                        symbol = ShipEngine.Symbol.ENGINE_IMPULSE_DRIVE_I,
                        name = "string",
                        description = "string",
                        condition = 0,
                        speed = 1,
                        requirements = ShipRequirements(
                            power = 0,
                            crew = 0,
                            slots = 0,
                        ),
                    ),
                    modules = listOf(
                        ShipModule(
                        symbol = ShipModule.Symbol.MODULE_MINERAL_PROCESSOR_I,
                        capacity = 0,
                        range = 0,
                        name = "string",
                        description = "string",
                        requirements = ShipRequirements(
                            power = 0,
                            crew = 0,
                            slots = 0,
                        ),
                    )
                    ),
                    mounts = listOf(
                        ShipMount(
                        symbol = ShipMount.Symbol.MOUNT_GAS_SIPHON_I,
                        name = "string",
                        description = "string",
                        strength = 0,
                        deposits = listOf(ShipMount.Deposits.QUARTZ_SAND),
                        requirements = ShipRequirements(
                            power = 0,
                            crew = 0,
                            slots = 0,
                        ),
                    )
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
                        )
                        ),
                    ),
                    fuel = ShipFuel(
                        current = 0,
                        capacity = 0,
                        consumed = ShipFuelConsumed(
                            amount = 0,
                            timestamp = Instant.parse("2019-08-24T14:15:22Z")
                        ),
                    ),
                ),
                token = "string",
            )
        )
    }
})
