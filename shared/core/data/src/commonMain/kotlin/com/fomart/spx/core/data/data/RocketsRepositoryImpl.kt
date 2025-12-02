package com.fomart.spx.core.data.data

import com.fomart.spx.core.data.cache.RocketsCacheDataSource
import com.fomart.spx.core.data.domain.RocketsRepository
import com.fomart.spx.core.model.Rocket
import com.fomart.spx.core.model.RocketPreview
import com.fomart.spx.core.model.domain.Result
import com.fomart.spx.core.model.domain.error.NetworkError
import com.fomart.spx.core.network.domain.RocketsDataSource

class RocketsRepositoryImpl(
    private val rocketsDataSource: RocketsDataSource,
    private val cacheDataSource: RocketsCacheDataSource
) : RocketsRepository {

    override suspend fun getRocketPreviews(): Result<List<RocketPreview>, NetworkError> {
        // Return cached if available
        cacheDataSource.getRocketPreviews()?.let { cached ->
            return Result.Success(cached)
        }

        val result = rocketsDataSource.getRocketPreviews()
        if (result is Result.Success) {
            cacheDataSource.saveRocketPreviews(result.data)
        }
        return result
    }

    override suspend fun getRocketDetails(id: String): Result<Rocket, NetworkError> {
        cacheDataSource.getRocketDetails(id)?.let { cached ->
            return Result.Success(cached)
        }

        val result = rocketsDataSource.getRocketDetails(id)
        if (result is Result.Success) {
            cacheDataSource.saveRocketDetails(result.data)
        }
        return result
    }
}