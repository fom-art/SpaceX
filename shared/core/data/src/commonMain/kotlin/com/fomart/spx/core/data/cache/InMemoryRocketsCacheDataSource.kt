package com.fomart.spx.core.data.cache

import com.fomart.spx.core.model.Rocket
import com.fomart.spx.core.model.RocketPreview

class InMemoryRocketsCacheDataSource : RocketsCacheDataSource {

    private var rocketsCache: List<RocketPreview>? = null
    private val rocketDetailsCache: MutableMap<String, Rocket> = mutableMapOf()

    override suspend fun getRocketPreviews(): List<RocketPreview>? = rocketsCache

    override suspend fun saveRocketPreviews(previews: List<RocketPreview>) {
        rocketsCache = previews
    }

    override suspend fun getRocketDetails(id: String): Rocket? = rocketDetailsCache[id]

    override suspend fun saveRocketDetails(rocket: Rocket) {
        rocketDetailsCache[rocket.rocketId] = rocket
    }

    override fun clear() {
        rocketsCache = null
        rocketDetailsCache.clear()
    }
}
