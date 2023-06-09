package com.iamincendium.spacetraders.api.client.internal

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*

private const val AUTH_PREFIX = "-> Authorization: Bearer"
private val AUTH_REGEX = """$AUTH_PREFIX.*""".toRegex(RegexOption.IGNORE_CASE)

internal fun defaultHttpClient(
    engine: HttpClientEngine = defaultHttpEngine(),
    logLevel: LogLevel = LogLevel.INFO,
) = HttpClient(engine) {
    install(Logging) {
        logger = object : Logger {
            private val delegate = Logger.DEFAULT

            override fun log(message: String) {
                delegate.log(message.replace(AUTH_REGEX, "$AUTH_PREFIX <token hidden>"))
            }
        }
        level = logLevel
    }

    install(ContentNegotiation) {
        json()
    }

    expectSuccess = false
}

internal expect fun defaultHttpEngine(): HttpClientEngine
