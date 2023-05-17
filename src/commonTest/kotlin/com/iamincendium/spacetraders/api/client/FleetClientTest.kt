package com.iamincendium.spacetraders.api.client

import assertk.assertThat
import com.iamincendium.spacetraders.api.models.*
import com.iamincendium.spacetraders.api.test.common.isValidPagedResponse
import com.iamincendium.spacetraders.api.test.common.isValidResponse
import com.iamincendium.spacetraders.api.test.common.mockApiClient
import io.kotest.core.spec.style.FunSpec
import io.ktor.http.*
import kotlinx.datetime.Instant

class FleetClientTest : FunSpec({
    test("listShips - should handle the example data") {
        val response = """
            {
                "data": [
                    {
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
                    }
                ],
                "meta": {
                    "total": 0,
                    "page": 0,
                    "limit": 0
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Get, "/my/ships", response)

        assertThat(api.fleet.listShips()).isValidPagedResponse(
            listOf(Ship(
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
                modules = listOf(ShipModule(
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
                )),
                mounts = listOf(ShipMount(
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
                )),
                cargo = ShipCargo(
                    capacity = 0,
                    units = 0,
                    inventory = listOf(ShipCargoItem(
                        symbol = "string",
                        name = "string",
                        description = "string",
                        units = 1,
                    )),
                ),
                fuel = ShipFuel(
                    current = 0,
                    capacity = 0,
                    consumed = ShipFuelConsumed(
                        amount = 0,
                        timestamp = Instant.parse("2019-08-24T14:15:22Z")
                    ),
                ),
            )),
            PageData(0, 0, 0),
        )
    }

    test("purchaseShip - should handle the example data") {
        val response = """
            {
                "data": {
                    "agent": {
                        "accountId": "string",
                        "symbol": "string",
                        "headquarters": "string",
                        "credits": 0
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
                    "transaction": {
                        "waypointSymbol": "string",
                        "shipSymbol": "string",
                        "price": 1,
                        "agentSymbol": "string",
                        "timestamp": "2019-08-24T14:15:22Z"
                    }
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Post, "/my/ships", response)

        val request = PurchaseShipRequest(
            shipType = ShipType.SHIP_PROBE,
            waypointSymbol = "string",
        )
        assertThat(api.fleet.purchaseShip(request)).isValidResponse(
            PurchaseShipResponse(
                agent = Agent(
                    accountId = "string",
                    symbol = "string",
                    headquarters = "string",
                    credits = 0,
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
                    modules = listOf(ShipModule(
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
                    )),
                    mounts = listOf(ShipMount(
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
                    )),
                    cargo = ShipCargo(
                        capacity = 0,
                        units = 0,
                        inventory = listOf(ShipCargoItem(
                            symbol = "string",
                            name = "string",
                            description = "string",
                            units = 1,
                        )),
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
                transaction = ShipyardTransaction(
                    waypointSymbol = "string",
                    shipSymbol = "string",
                    price = 1,
                    agentSymbol = "string",
                    timestamp = Instant.parse("2019-08-24T14:15:22Z"),
                ),
            )
        )
    }

    test("getShip - should handle the example data") {
        val response = """
            {
                "data": {
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
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Get, "/my/ships/string", response)

        assertThat(api.fleet.getShip("string")).isValidResponse(
            Ship(
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
                modules = listOf(ShipModule(
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
                )),
                mounts = listOf(ShipMount(
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
                )),
                cargo = ShipCargo(
                    capacity = 0,
                    units = 0,
                    inventory = listOf(ShipCargoItem(
                        symbol = "string",
                        name = "string",
                        description = "string",
                        units = 1,
                    )),
                ),
                fuel = ShipFuel(
                    current = 0,
                    capacity = 0,
                    consumed = ShipFuelConsumed(
                        amount = 0,
                        timestamp = Instant.parse("2019-08-24T14:15:22Z")
                    ),
                ),
            )
        )
    }

    test("getShipCargo - should handle the example data") {
        val response = """
            {
                "data": {
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
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Get, "/my/ships/string/cargo", response)

        assertThat(api.fleet.getShipCargo("string")).isValidResponse(
            ShipCargo(
                capacity = 0,
                units = 0,
                inventory = listOf(ShipCargoItem(
                    symbol = "string",
                    name = "string",
                    description = "string",
                    units = 1,
                )),
            )
        )
    }

    test("orbitShip - should handle the example data") {
        val response = """
            {
                "data": {
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
                    }
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Post, "/my/ships/string/orbit", response)

        assertThat(api.fleet.orbitShip("string")).isValidResponse(
            OrbitShipResponse(
                ShipNav(
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
            )
        )
    }

    test("shipRefine - should handle the example data") {
        val response = """
            {
                "data": {
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
                    "cooldown": {
                        "shipSymbol": "string",
                        "totalSeconds": 0,
                        "remainingSeconds": 0,
                        "expiration": "2019-08-24T14:15:22Z"
                    },
                    "produced": [
                        {
                            "tradeSymbol": "string",
                            "units": 0
                        }
                    ],
                    "consumed": [
                        {
                            "tradeSymbol": "string",
                            "units": 0
                        }
                    ]
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Post, "/my/ships/string/refine", response)

        val request = ShipRefineRequest(
            produce = ShipRefineRequest.Produce.IRON,
        )

        assertThat(api.fleet.shipRefine("string", request)).isValidResponse(
            ShipRefineResponse(
                cargo = ShipCargo(
                    capacity = 0,
                    units = 0,
                    inventory = listOf(
                        ShipCargoItem(
                            symbol = "string",
                            name = "string",
                            description = "string",
                            units = 1,
                    )),
                ),
                cooldown = Cooldown(
                    shipSymbol = "string",
                    totalSeconds = 0,
                    remainingSeconds = 0,
                    expiration = Instant.parse("2019-08-24T14:15:22Z"),
                ),
                produced = listOf(ShipRefineResponse.ManipulatedAmount(
                    tradeSymbol = "string",
                    units = 0,
                )),
                consumed = listOf(ShipRefineResponse.ManipulatedAmount(
                    tradeSymbol = "string",
                    units = 0,
                )),
            )
        )
    }

    test("createChart - should handle the example data") {
        val response = """
            {
                "data": {
                    "chart": {
                        "waypointSymbol": "string",
                        "submittedBy": "string",
                        "submittedOn": "2019-08-24T14:15:22Z"
                    },
                    "waypoint": {
                        "symbol": "string",
                        "type": "PLANET",
                        "systemSymbol": "string",
                        "x": 0,
                        "y": 0,
                        "orbitals": [
                            {
                                "symbol": "string"
                            }
                        ],
                        "faction": {
                            "symbol": "string"
                        },
                        "traits": [
                            {
                                "symbol": "UNCHARTED",
                                "name": "string",
                                "description": "string"
                            }
                        ],
                        "chart": {
                            "waypointSymbol": "string",
                            "submittedBy": "string",
                            "submittedOn": "2019-08-24T14:15:22Z"
                        }
                    }
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Post, "/my/ships/string/chart", response)

        assertThat(api.fleet.createChart("string")).isValidResponse(
            CreateChartResponse(
                chart = Chart(
                    waypointSymbol = "string",
                    submittedBy = "string",
                    submittedOn = Instant.parse("2019-08-24T14:15:22Z"),
                ),
                waypoint = Waypoint(
                    symbol = "string",
                    type = WaypointType.PLANET,
                    systemSymbol = "string",
                    x = 0,
                    y = 0,
                    orbitals = listOf(
                        WaypointOrbital(
                            symbol = "string",
                        ),
                    ),
                    faction = WaypointFaction(
                        symbol = "string",
                    ),
                    traits = listOf(WaypointTrait(
                        symbol = WaypointTrait.Symbol.UNCHARTED,
                        name = "string",
                        description =  "string",
                    )),
                    chart = Chart(
                        waypointSymbol = "string",
                        submittedBy = "string",
                        submittedOn = Instant.parse("2019-08-24T14:15:22Z"),
                    ),
                ),
            )
        )

    }

    test("getShipCooldown - should handle the example data") {
        val response = """
            {
                "data": {
                    "shipSymbol": "string",
                    "totalSeconds": 0,
                    "remainingSeconds": 0,
                    "expiration": "2019-08-24T14:15:22Z"
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Get, "/my/ships/string/cooldown", response)

        assertThat(api.fleet.getShipCooldown("string")).isValidResponse(
            Cooldown(
                shipSymbol = "string",
                totalSeconds = 0,
                remainingSeconds = 0,
                expiration = Instant.parse("2019-08-24T14:15:22Z"),
            ),
        )
    }

    test("dockShip - should handle the example data") {
        val response = """
            {
                "data": {
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
                    }
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Post, "/my/ships/string/dock", response)

        assertThat(api.fleet.dockShip("string")).isValidResponse(
            DockShipResponse(
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
                )
            )
        )
    }
    
    test("createSurvey - should handle the example data") {
        val response = """
            {
                "data": {
                    "cooldown": {
                        "shipSymbol": "string",
                        "totalSeconds": 0,
                        "remainingSeconds": 0,
                        "expiration": "2019-08-24T14:15:22Z"
                    },
                    "surveys": [
                        {
                            "signature": "string",
                            "symbol": "string",
                            "deposits": [
                                {
                                    "symbol": "string"
                                }
                            ],
                            "expiration": "2019-08-24T14:15:22Z",
                            "size": "SMALL"
                        }
                    ]
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Post, "/my/ships/string/survey", response)

        assertThat(api.fleet.createSurvey("string")).isValidResponse(
            CreateSurveyResponse(
                cooldown = Cooldown(
                    shipSymbol = "string",
                    totalSeconds = 0,
                    remainingSeconds = 0,
                    expiration = Instant.parse("2019-08-24T14:15:22Z"),
                ),
                surveys = listOf(Survey(
                    signature = "string",
                    symbol = "string",
                    deposits = listOf(SurveyDeposit(
                        symbol = "string",
                    )),
                    expiration = Instant.parse("2019-08-24T14:15:22Z"),
                    propertySize = Survey.PropertySize.SMALL,
                )),
            )
        )
    }
    
    test("extractResources - should handle the example data") {
        val response = """
            {
                "data": {
                    "cooldown": {
                        "shipSymbol": "string",
                        "totalSeconds": 0,
                        "remainingSeconds": 0,
                        "expiration": "2019-08-24T14:15:22Z"
                    },
                    "extraction": {
                        "shipSymbol": "string",
                        "yield": {
                            "symbol": "string",
                            "units": 0
                        }
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

        val api = mockApiClient(HttpMethod.Post, "/my/ships/string/extract", response)

        assertThat(api.fleet.extractResources("string")).isValidResponse(
            ExtractResourcesResponse(
                cooldown = Cooldown(
                    shipSymbol = "string",
                    totalSeconds = 0,
                    remainingSeconds = 0,
                    expiration = Instant.parse("2019-08-24T14:15:22Z"),
                ),
                extraction = Extraction(
                    shipSymbol = "string",
                    yield = ExtractionYield(
                        symbol = "string",
                        units = 0,
                    ),
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
            )
        )
    }

    test("jettison - should handle the example data") {
        val response = """
            {
                "data": {
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

        val api = mockApiClient(HttpMethod.Post, "/my/ships/string/jettison", response)

        val request = JettisonRequest(
            symbol = "string",
            units = 1,
        )

        assertThat(api.fleet.jettison("string", request)).isValidResponse(
            JettisonResponse(
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
            )
        )
    }

    test("jumpShip - should handle the example data") {
        val response = """
            {
                "data": {
                    "cooldown": {
                        "shipSymbol": "string",
                        "totalSeconds": 0,
                        "remainingSeconds": 0,
                        "expiration": "2019-08-24T14:15:22Z"
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
                    }
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Post, "/my/ships/string/jump", response)

        val request = JumpShipRequest(
            systemSymbol = "string",
        )

        assertThat(api.fleet.jumpShip("string", request)).isValidResponse(
            JumpShipResponse(
                cooldown = Cooldown(
                    shipSymbol = "string",
                    totalSeconds = 0,
                    remainingSeconds = 0,
                    expiration = Instant.parse("2019-08-24T14:15:22Z"),
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
            )
        )
    }

    test("navigateShip - should handle the example data") {
        val response = """
            {
                "data": {
                    "fuel": {
                        "current": 0,
                        "capacity": 0,
                        "consumed": {
                            "amount": 0,
                            "timestamp": "2019-08-24T14:15:22Z"
                        }
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
                    }
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Post, "/my/ships/string/navigate", response)
        val request = NavigateShipRequest(
            waypointSymbol = "string",
        )

        assertThat(api.fleet.navigateShip("string", request)).isValidResponse(
            NavigateShipResponse(
                fuel = ShipFuel(
                    current = 0,
                    capacity = 0,
                    consumed = ShipFuelConsumed(
                        amount = 0,
                        timestamp = Instant.parse("2019-08-24T14:15:22Z"),
                    ),
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
            )
        )
    }

    test("updateShipNav - should handle the example data") {
        val response = """
            {
                "data": {
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
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Patch, "/my/ships/string/nav", response)

        val request = PatchShipNavRequest(
            flightMode = ShipNavFlightMode.CRUISE,
        )

        assertThat(api.fleet.updateShipNav("string", request)).isValidResponse(
            ShipNav(
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
            )
        )
    }

    test("getShipNav - should handle the example data") {
        val response = """
            {
                "data": {
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
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Get, "/my/ships/string/nav", response)

        assertThat(api.fleet.getShipNav("string")).isValidResponse(
            ShipNav(
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
            )
        )
    }

    test("warpShip - should handle the example data") {
        val response = """
            {
                "data": {
                    "fuel": {
                        "current": 0,
                        "capacity": 0,
                        "consumed": {
                            "amount": 0,
                            "timestamp": "2019-08-24T14:15:22Z"
                        }
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
                    }
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Post, "/my/ships/string/warp", response)

        val request = NavigateShipRequest(
            waypointSymbol = "string",
        )

        assertThat(api.fleet.warpShip("string", request)).isValidResponse(
            NavigateShipResponse(
                fuel = ShipFuel(
                    current = 0,
                    capacity = 0,
                    consumed = ShipFuelConsumed(
                        amount = 0,
                        timestamp = Instant.parse("2019-08-24T14:15:22Z"),
                    ),
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
            )
        )
    }

    test("sellCargo - should handle the example data") {
        val response = """
            {
                "data": {
                    "agent": {
                        "accountId": "string",
                        "symbol": "string",
                        "headquarters": "string",
                        "credits": 0
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
                    },
                    "transaction": {
                        "waypointSymbol": "string",
                        "shipSymbol": "string",
                        "tradeSymbol": "string",
                        "type": "PURCHASE",
                        "units": 1,
                        "pricePerUnit": 1,
                        "totalPrice": 1,
                        "timestamp": "2019-08-24T14:15:22Z"
                    }
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Post, "/my/ships/string/sell", response)

        val request = SellCargoRequest(
            symbol = "string",
            units = 0,
        )

        assertThat(api.fleet.sellCargo("string", request)).isValidResponse(
            CargoTransaction(
                agent = Agent(
                    accountId = "string",
                    symbol = "string",
                    headquarters = "string",
                    credits = 0,
                ),
                cargo = ShipCargo(
                    capacity = 0,
                    units = 0,
                    inventory = listOf(ShipCargoItem(
                        symbol = "string",
                        name = "string",
                        description = "string",
                        units = 1,
                    )),
                ),
                transaction = MarketTransaction(
                    waypointSymbol = "string",
                    shipSymbol = "string",
                    tradeSymbol = "string",
                    type = MarketTransaction.Type.PURCHASE,
                    units = 1,
                    pricePerUnit = 1,
                    totalPrice = 1,
                    timestamp = Instant.parse("2019-08-24T14:15:22Z"),
                ),
            )
        )
    }

    test("scanSystems - should handle the example data") {
        val response = """
            {
                "data": {
                    "cooldown": {
                        "shipSymbol": "string",
                        "totalSeconds": 0,
                        "remainingSeconds": 0,
                        "expiration": "2019-08-24T14:15:22Z"
                    },
                    "systems": [
                        {
                            "symbol": "string",
                            "sectorSymbol": "string",
                            "type": "NEUTRON_STAR",
                            "x": 0,
                            "y": 0,
                            "distance": 0
                        }
                    ]
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Post, "/my/ships/string/scan/systems", response)

        assertThat(api.fleet.scanSystems("string")).isValidResponse(
            SystemScanResult(
                cooldown = Cooldown(
                    shipSymbol = "string",
                    totalSeconds = 0,
                    remainingSeconds = 0,
                    expiration = Instant.parse("2019-08-24T14:15:22Z"),
                ),
                systems = listOf(ScannedSystem(
                    symbol = "string",
                    sectorSymbol = "string",
                    type = SystemType.NEUTRON_STAR,
                    x = 0,
                    y = 0,
                    distance = 0,
                )),
            )
        )
    }

    test("scanWaypoints - should handle the example data") {
        val response = """
            {
                "data": {
                    "cooldown": {
                        "shipSymbol": "string",
                        "totalSeconds": 0,
                        "remainingSeconds": 0,
                        "expiration": "2019-08-24T14:15:22Z"
                    },
                    "waypoints": [
                        {
                            "symbol": "string",
                            "type": "PLANET",
                            "systemSymbol": "string",
                            "x": 0,
                            "y": 0,
                            "orbitals": [
                                {
                                    "symbol": "string"
                                }
                            ],
                            "faction": {
                                "symbol": "string"
                            },
                            "traits": [
                                {
                                    "symbol": "UNCHARTED",
                                    "name": "string",
                                    "description": "string"
                                }
                            ],
                            "chart": {
                                "waypointSymbol": "string",
                                "submittedBy": "string",
                                "submittedOn": "2019-08-24T14:15:22Z"
                            }
                        }
                    ]
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Post, "/my/ships/string/scan/waypoints", response)

        assertThat(api.fleet.scanWaypoints("string")).isValidResponse(
            WaypointScanResult(
                cooldown = Cooldown(
                    shipSymbol = "string",
                    totalSeconds = 0,
                    remainingSeconds = 0,
                    expiration = Instant.parse("2019-08-24T14:15:22Z"),
                ),
                waypoints = listOf(ScannedWaypoint(
                    symbol = "string",
                    type = WaypointType.PLANET,
                    systemSymbol = "string",
                    x = 0,
                    y = 0,
                    orbitals = listOf(WaypointOrbital("string")),
                    faction = WaypointFaction("string"),
                    traits = listOf(WaypointTrait(
                        symbol = WaypointTrait.Symbol.UNCHARTED,
                        name = "string",
                        description = "string",
                    )),
                    chart = Chart(
                        waypointSymbol = "string",
                        submittedBy = "string",
                        submittedOn = Instant.parse("2019-08-24T14:15:22Z"),
                    ),
                )),
            )
        )
    }

    test("scanShips - should handle the example data") {
        val response = """
            {
                "data": {
                    "cooldown": {
                        "shipSymbol": "string",
                        "totalSeconds": 0,
                        "remainingSeconds": 0,
                        "expiration": "2019-08-24T14:15:22Z"
                    },
                    "ships": [
                        {
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
                            "frame": {
                                "symbol": "string"
                            },
                            "reactor": {
                                "symbol": "string"
                            },
                            "engine": {
                                "symbol": "string"
                            },
                            "mounts": [
                                {
                                    "symbol": "string"
                                }
                            ]
                        }
                    ]
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Post, "/my/ships/string/scan/ships", response)

        assertThat(api.fleet.scanShips("string")).isValidResponse(
            ShipScanResult(
                cooldown = Cooldown(
                    shipSymbol = "string",
                    totalSeconds = 0,
                    remainingSeconds = 0,
                    expiration = Instant.parse("2019-08-24T14:15:22Z"),
                ),
                ships = listOf(ScannedShip(
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
                    frame = ScannedShipFrame(
                        symbol = "string",
                    ),
                    reactor = ScannedShipReactor(
                        symbol = "string",
                    ),
                    engine = ScannedShipEngine(
                        symbol = "string",
                    ),
                    mounts = listOf(ScannedShipMount(
                        symbol = "string",
                    )),
                )),
            )
        )
    }

    test("refuelShip - should handle the example data") {
        val response = """
            {
                "data": {
                    "agent": {
                        "accountId": "string",
                        "symbol": "string",
                        "headquarters": "string",
                        "credits": 0
                    },
                    "fuel": {
                        "current": 0,
                        "capacity": 0,
                        "consumed": {
                            "amount": 0,
                            "timestamp": "2019-08-24T14:15:22Z"
                        }
                    }
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Post, "/my/ships/string/refuel", response)

        assertThat(api.fleet.refuelShip("string")).isValidResponse(
            RefuelShipResponse(
                agent = Agent(
                    accountId = "string",
                    symbol = "string",
                    headquarters = "string",
                    credits = 0,
                ),
                fuel = ShipFuel(
                    current = 0,
                    capacity = 0,
                    consumed = ShipFuelConsumed(
                        amount = 0,
                        timestamp = Instant.parse("2019-08-24T14:15:22Z")
                    ),
                ),
            )
        )
    }

    test("purchaseCargo - should handle the example data") {
        val response = """
            {
                "data": {
                    "agent": {
                        "accountId": "string",
                        "symbol": "string",
                        "headquarters": "string",
                        "credits": 0
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
                    },
                    "transaction": {
                        "waypointSymbol": "string",
                        "shipSymbol": "string",
                        "tradeSymbol": "string",
                        "type": "PURCHASE",
                        "units": 1,
                        "pricePerUnit": 1,
                        "totalPrice": 1,
                        "timestamp": "2019-08-24T14:15:22Z"
                    }
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Post, "/my/ships/string/purchase", response)

        val request = PurchaseCargoRequest(
            symbol = "string",
            units = 0,
        )

        assertThat(api.fleet.purchaseCargo("string", request)).isValidResponse(
            CargoTransaction(
                agent = Agent(
                    accountId = "string",
                    symbol = "string",
                    headquarters = "string",
                    credits = 0,
                ),
                cargo = ShipCargo(
                    capacity = 0,
                    units = 0,
                    inventory = listOf(ShipCargoItem(
                        symbol = "string",
                        name = "string",
                        description = "string",
                        units = 1,
                    )),
                ),
                transaction = MarketTransaction(
                    waypointSymbol = "string",
                    shipSymbol = "string",
                    tradeSymbol = "string",
                    type = MarketTransaction.Type.PURCHASE,
                    units = 1,
                    pricePerUnit = 1,
                    totalPrice = 1,
                    timestamp = Instant.parse("2019-08-24T14:15:22Z"),
                ),
            )
        )
    }

    test("transferCargo - should handle the example data") {
        val response = """
            {
                "data": {
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

        val api = mockApiClient(HttpMethod.Post, "/my/ships/string/transfer", response)

        val request = TransferCargoRequest(
            tradeSymbol = "string",
            units = 0,
            shipSymbol = "string",
        )

        assertThat(api.fleet.transferCargo("string", request)).isValidResponse(
            CargoTransfer(
                cargo = ShipCargo(
                    capacity = 0,
                    units = 0,
                    inventory = listOf(ShipCargoItem(
                        symbol = "string",
                        name = "string",
                        description = "string",
                        units = 1,
                    )),
                ),
            )
        )
    }
})
