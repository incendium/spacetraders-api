package com.iamincendium.spacetraders.api.client

import assertk.assertThat
import com.iamincendium.spacetraders.api.models.*
import com.iamincendium.spacetraders.api.test.common.isValidPagedResponse
import com.iamincendium.spacetraders.api.test.common.isValidResponse
import com.iamincendium.spacetraders.api.test.common.mockApiClient
import io.kotest.core.spec.style.FunSpec
import io.ktor.http.*
import kotlinx.datetime.Instant

class SystemsClientTest : FunSpec({
    test("listSystems - should handle the example data") {
        val response = """
            {
                "data": [
                    {
                        "symbol": "string",
                        "sectorSymbol": "string",
                        "type": "NEUTRON_STAR",
                        "x": 0,
                        "y": 0,
                        "waypoints": [
                            {
                                "symbol": "string",
                                "type": "PLANET",
                                "x": 0,
                                "y": 0
                            }
                        ],
                        "factions": [
                            {
                                "symbol": "string"
                            }
                        ]
                    }
                ],
                "meta": {
                    "total": 0,
                    "page": 0,
                    "limit": 0
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Get, "/systems", response)

        assertThat(api.systems.listSystems()).isValidPagedResponse(
            listOf(System(
                symbol = "string",
                sectorSymbol = "string",
                type = SystemType.NEUTRON_STAR,
                x = 0,
                y = 0,
                waypoints = listOf(SystemWaypoint(
                    symbol = "string",
                    type = WaypointType.PLANET,
                    x = 0,
                    y = 0,
                )),
                factions = listOf(SystemFaction("string")),
            )),
            PageData(0, 0, 0),
        )
    }

    test("getSystem - should handle the example data") {
        val response = """
            {
                "data": {
                    "symbol": "string",
                    "sectorSymbol": "string",
                    "type": "NEUTRON_STAR",
                    "x": 0,
                    "y": 0,
                    "waypoints": [
                        {
                            "symbol": "string",
                            "type": "PLANET",
                            "x": 0,
                            "y": 0
                        }
                    ],
                    "factions": [
                        {
                            "symbol": "string"
                        }
                    ]
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Get, "/systems/string", response)

        assertThat(api.systems.getSystem("string")).isValidResponse(
            System(
                symbol = "string",
                sectorSymbol = "string",
                type = SystemType.NEUTRON_STAR,
                x = 0,
                y = 0,
                waypoints = listOf(SystemWaypoint(
                    symbol = "string",
                    type = WaypointType.PLANET,
                    x = 0,
                    y = 0,
                )),
                factions = listOf(SystemFaction("string")),
            )
        )
    }

    test("listWaypoints - should handle the example data") {
        val response = """
            {
                "data": [
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
                ],
                "meta": {
                    "total": 0,
                    "page": 0,
                    "limit": 0
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Get, "/systems/string/waypoints", response)

        assertThat(api.systems.listWaypoints("string")).isValidPagedResponse(
            listOf(Waypoint(
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
            PageData(0, 0, 0),
        )
    }

    test("getWaypoint - should handle the example data") {
        val response = """
            {
                "data": {
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
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Get, "/systems/string/waypoints/string", response)

        assertThat(api.systems.getWaypoint("string", "string")).isValidResponse(
            Waypoint(
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
            )
        )
    }

    test("getMarket - should handle the example data") {
        val response = """
            {
                "data": {
                    "symbol": "string",
                    "exports": [
                        {
                            "symbol": "PRECIOUS_STONES",
                            "name": "string",
                            "description": "string"
                        }
                    ],
                    "imports": [
                        {
                            "symbol": "PRECIOUS_STONES",
                            "name": "string",
                            "description": "string"
                        }
                    ],
                    "exchange": [
                        {
                            "symbol": "PRECIOUS_STONES",
                            "name": "string",
                            "description": "string"
                        }
                    ],
                    "transactions": [
                        {
                            "waypointSymbol": "string",
                            "shipSymbol": "string",
                            "tradeSymbol": "string",
                            "type": "PURCHASE",
                            "units": 1,
                            "pricePerUnit": 1,
                            "totalPrice": 1,
                            "timestamp": "2019-08-24T14:15:22Z"
                        }
                    ],
                    "tradeGoods": [
                        {
                            "symbol": "string",
                            "tradeVolume": 1,
                            "supply": "SCARCE",
                            "purchasePrice": 0,
                            "sellPrice": 0
                        }
                    ]
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Get, "/systems/string/waypoints/string/market", response)

        assertThat(api.systems.getMarket("string", "string")).isValidResponse(
            Market(
                symbol = "string",
                exports = listOf(TradeGood(
                    TradeSymbol.PRECIOUS_STONES,
                    "string",
                    "string",
                )),
                imports = listOf(TradeGood(
                    TradeSymbol.PRECIOUS_STONES,
                    "string",
                    "string",
                )),
                exchange = listOf(TradeGood(
                    TradeSymbol.PRECIOUS_STONES,
                    "string",
                    "string",
                )),
                transactions = listOf(MarketTransaction(
                    waypointSymbol = "string",
                    shipSymbol = "string",
                    tradeSymbol = "string",
                    type = MarketTransaction.Type.PURCHASE,
                    units = 1,
                    pricePerUnit = 1,
                    totalPrice = 1,
                    timestamp = Instant.parse("2019-08-24T14:15:22Z"),
                )),
                tradeGoods = listOf(MarketTradeGood(
                    symbol = "string",
                    tradeVolume = 1,
                    supply = MarketTradeGood.Supply.SCARCE,
                    purchasePrice = 0,
                    sellPrice = 0,
                )),
            )
        )
    }

    test("getShipyard - should handle the example data") {
        val response = """
            {
                "data": {
                    "symbol": "string",
                    "shipTypes": [
                        {
                            "type": "SHIP_PROBE"
                        }
                    ],
                    "transactions": [
                        {
                            "waypointSymbol": "string",
                            "shipSymbol": "string",
                            "price": 1,
                            "agentSymbol": "string",
                            "timestamp": "2019-08-24T14:15:22Z"
                        }
                    ],
                    "ships": [
                        {
                            "type": "SHIP_PROBE",
                            "name": "string",
                            "description": "string",
                            "purchasePrice": 0,
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
                            ]
                        }
                    ]
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Get, "/systems/string/waypoints/string/shipyard", response)

        assertThat(api.systems.getShipyard("string", "string")).isValidResponse(
            Shipyard(
                symbol = "string",
                shipTypes = listOf(ShipyardShipType(ShipType.SHIP_PROBE)),
                transactions = listOf(ShipyardTransaction(
                    waypointSymbol = "string",
                    shipSymbol = "string",
                    price = 1,
                    agentSymbol = "string",
                    timestamp = Instant.parse("2019-08-24T14:15:22Z"),
                )),
                ships = listOf(ShipyardShip(
                    type = ShipType.SHIP_PROBE,
                    name = "string",
                    description = "string",
                    purchasePrice = 0,
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
                )),
            )
        )
    }

    test("getJumpGate - should handle the example data") {
        val response = """
            {
                "data": {
                    "jumpRange": 0,
                    "factionSymbol": "string",
                    "connectedSystems": [
                        {
                            "symbol": "string",
                            "sectorSymbol": "string",
                            "type": "NEUTRON_STAR",
                            "factionSymbol": "string",
                            "x": 0,
                            "y": 0,
                            "distance": 0
                        }
                    ]
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Get, "/systems/string/waypoints/string/jump-gate", response)

        assertThat(api.systems.getJumpGate("string", "string")).isValidResponse(
            JumpGate(
                jumpRange = 0,
                factionSymbol = "string",
                connectedSystems = listOf(ConnectedSystem(
                    symbol = "string",
                    sectorSymbol = "string",
                    type = SystemType.NEUTRON_STAR,
                    factionSymbol = "string",
                    x = 0,
                    y = 0,
                    distance = 0,
                ))
            )
        )
    }
})
