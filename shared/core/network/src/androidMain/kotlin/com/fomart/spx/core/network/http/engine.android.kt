package com.fomart.spx.core.network.http

import io.ktor.client.engine.okhttp.OkHttp

actual val engine: io.ktor.client.engine.HttpClientEngine
    get() = OkHttp.create()