package com.fomart.spx.core.data.cache

import com.fomart.spx.core.model.Rocket
import com.fomart.spx.core.model.RocketPreview

interface RocketsCacheDataSource {
    suspend fun getRocketPreviews(): List<RocketPreview>?
    suspend fun saveRocketPreviews(previews: List<RocketPreview>)
    
    suspend fun getRocketDetails(id: String): Rocket?
    suspend fun saveRocketDetails(rocket: Rocket)
    
    fun clear()
}
