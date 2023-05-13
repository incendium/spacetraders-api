package com.iamincendium.spacetraders.api.client.internal

import io.ktor.client.engine.*
import io.ktor.client.engine.js.*

internal actual fun defaultHttpEngine(): HttpClientEngine = Js.create()
