package com.fomart.spx.core.network.http

import io.ktor.client.engine.darwin.Darwin

actual val engine: io.ktor.client.engine.HttpClientEngine
    get() = Darwin.create()