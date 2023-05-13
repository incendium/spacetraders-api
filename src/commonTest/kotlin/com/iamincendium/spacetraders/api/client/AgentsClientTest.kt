package com.iamincendium.spacetraders.api.client

import assertk.assertThat
import com.iamincendium.spacetraders.api.models.Agent
import com.iamincendium.spacetraders.api.test.common.isValidResponse
import com.iamincendium.spacetraders.api.test.common.mockApiClient
import io.kotest.core.spec.style.FunSpec

class AgentsClientTest : FunSpec({
    test("getMyAgent - should handle the example data") {
        val response = """
            {
                "data": {
                    "accountId": "string",
                    "symbol": "string",
                    "headquarters": "string",
                    "credits": 0
                }
            }
        """.trimIndent()

        val api = mockApiClient("/my/agent", response)

        assertThat(api.agents.getMyAgent()).isValidResponse(Agent(
            accountId = "string",
            symbol = "string",
            headquarters = "string",
            credits = 0,
        ))
    }
})
