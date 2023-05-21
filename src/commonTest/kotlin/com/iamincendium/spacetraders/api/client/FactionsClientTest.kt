package com.iamincendium.spacetraders.api.client

import assertk.assertThat
import com.iamincendium.spacetraders.api.models.Faction
import com.iamincendium.spacetraders.api.models.FactionTrait
import com.iamincendium.spacetraders.api.models.PageData
import com.iamincendium.spacetraders.api.test.common.isValidPagedResponse
import com.iamincendium.spacetraders.api.test.common.isValidResponse
import com.iamincendium.spacetraders.api.test.common.mockApiClient
import io.kotest.core.spec.style.FunSpec
import io.ktor.http.*

class FactionsClientTest : FunSpec({
    test("listFactions - should handle the example data") {
        val response = """
            {
                "data": [
                    {
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
                    }
                ],
                "meta": {
                    "total": 0,
                    "page": 0,
                    "limit": 0
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Get, "/factions", response)

        assertThat(api.factions.listFactions()).isValidPagedResponse(
            listOf(Faction(
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
            )),
            PageData(0, 0, 0),
        )
    }

    test("getFaction - should handle the example data") {
        val response = """
            {
                "data": {
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
                }
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Get, "/factions/string", response)

        assertThat(api.factions.getFaction("string")).isValidResponse(
            Faction(
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
        )
    }
})
