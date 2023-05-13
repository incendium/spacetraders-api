package com.iamincendium.spacetraders.api.client.internal

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*

private const val BOT_AUTH_PREFIX = "-> Authorization: Bearer"

internal fun defaultHttpClient() = HttpClient(CIO) {
    install(Logging) {
        logger = object : Logger {
            private val delegate = Logger.DEFAULT

            override fun log(message: String) {
                delegate.log(
                    if (message.startsWith(BOT_AUTH_PREFIX)) {
                        "$BOT_AUTH_PREFIX <token hidden>"
                    } else {
                        message
                    }
                )
            }
        }
        level = LogLevel.INFO
    }

    install(ContentNegotiation) {
        json()
    }

    expectSuccess = false
}
