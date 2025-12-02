package com.fomart.spx.core.network.domain

import com.fomart.spx.core.model.Rocket
import com.fomart.spx.core.model.RocketPreview
import com.fomart.spx.core.model.domain.Result
import com.fomart.spx.core.model.domain.error.NetworkError

interface RocketsDataSource {
    suspend fun getRocketPreviews(): Result<List<RocketPreview>, NetworkError>
    suspend fun getRocketDetails(id: String): Result<Rocket, NetworkError>?
}