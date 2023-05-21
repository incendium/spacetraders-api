package com.iamincendium.spacetraders.api.client

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.github.michaelbull.result.Ok
import com.iamincendium.spacetraders.api.models.StatusResponse
import com.iamincendium.spacetraders.api.test.common.mockApiClient
import io.kotest.core.spec.style.FunSpec
import io.ktor.http.*

class DefaultClientTest : FunSpec({
    test("getMyAgent - should handle the example data") {
        val response = """
            {
                "status": "string",
                "version": "string",
                "resetDate": "string",
                "description": "string",
                "stats": {
                    "agents": 0,
                    "ships": 0,
                    "systems": 0,
                    "waypoints": 0
                },
                "leaderboards": {
                    "mostCredits": [
                        {
                            "agentSymbol": "string",
                            "credits": 0
                        }
                    ],
                    "mostSubmittedCharts": [
                        {
                            "agentSymbol": "string",
                            "chartCount": 0
                        }
                    ]
                },
                "serverResets": {
                    "next": "string",
                    "frequency": "string"
                },
                "announcements": [
                    {
                        "title": "string",
                        "body": "string"
                    }
                ],
                "links": [
                    {
                        "name": "string",
                        "url": "string"
                    }
                ]
            }
        """.trimIndent()

        val api = mockApiClient(HttpMethod.Get, "/", response)

        assertThat(api.default.status()).isEqualTo(Ok(StatusResponse(
            status = "string",
            version = "string",
            resetDate = "string",
            description = "string",
            stats = StatusResponse.Stats(
                agents = 0,
                ships = 0,
                systems = 0,
                waypoints = 0,
            ),
            leaderboards = StatusResponse.Leaderboards(
                mostCredits = listOf(StatusResponse.Leaderboards.MostCreditsEntry(
                    agentSymbol = "string",
                    credits = 0,
                )),
                mostSubmittedCharts = listOf(StatusResponse.Leaderboards.MostSubmittedChartsEntry(
                    agentSymbol = "string",
                    chartCount = 0,
                )),
            ),
            serverResets = StatusResponse.ServerResets(
                next = "string",
                frequency = "string",
            ),
            announcements = listOf(StatusResponse.Announcement(
                title = "string",
                body = "string",
            )),
            links = listOf(StatusResponse.Link(
                name = "string",
                url = "string",
            )),
        )))
    }
})
