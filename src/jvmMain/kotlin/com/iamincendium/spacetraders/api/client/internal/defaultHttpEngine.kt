package com.iamincendium.spacetraders.api.client.internal

import io.ktor.client.engine.*
import io.ktor.client.engine.cio.*

internal actual fun defaultHttpEngine(): HttpClientEngine = CIO.create()
