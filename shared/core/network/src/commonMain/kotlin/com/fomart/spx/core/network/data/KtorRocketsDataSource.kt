package com.fomart.spx.core.network.data

import com.fomart.spx.core.model.Rocket
import com.fomart.spx.core.model.RocketPreview
import com.fomart.spx.core.model.Stage
import com.fomart.spx.core.model.domain.Result
import com.fomart.spx.core.model.domain.error.NetworkError
import com.fomart.spx.core.network.data.dto.RocketDto
import com.fomart.spx.core.network.domain.RocketsDataSource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.util.reflect.typeInfo
import kotlinx.datetime.LocalDateTime

class KtorRocketsDataSource(private val client: HttpClient) : RocketsDataSource {

    private companion object {
        const val BASE_URL = "https://api.spacexdata.com/v3/rockets"
    }

    override suspend fun getRocketPreviews(): Result<List<RocketPreview>, NetworkError> {
        return try {
            val httpResponse: HttpResponse = client.get(BASE_URL)
            val response: List<RocketDto> = httpResponse.body(typeInfo<List<RocketDto>>())

            val rocketPreviews = response.map { dto ->
                RocketPreview(
                    id = dto.id,
                    name = dto.rocketName,
                    firstFlightDate = parseDateTime(dto.firstFlight)
                )
            }

            Result.Success(rocketPreviews)
        } catch (e: Exception) {
            Result.Error(e.toNetworkError())
        }
    }

    override suspend fun getRocketDetails(id: String): Result<Rocket, NetworkError> {
        return try {
            val response: RocketDto = client.get("$BASE_URL/$id").body()

            val stages = listOfNotNull(
                response.firstStage?.let { firstStage ->
                    Stage(
                        reusable = firstStage.reusable,
                        engines = firstStage.engines,
                        fuel = firstStage.fuelAmountTons.toInt(),
                        burnTime = firstStage.burnTimeSec ?: 0
                    )
                },
                response.secondStage?.let { secondStage ->
                    Stage(
                        reusable = secondStage.reusable,
                        engines = secondStage.engines,
                        fuel = secondStage.fuelAmountTons.toInt(),
                        burnTime = secondStage.burnTimeSec ?: 0
                    )
                }
            )

            val rocket = Rocket(
                rocketId = response.rocketId,
                description = response.description,
                height = response.height.meters?.toInt() ?: 0,
                diameter = response.diameter.meters?.toInt() ?: 0,
                massKg = response.mass.kg,
                stages = stages,
                photoLinks = response.flickrImages
            )

            Result.Success(rocket)
        } catch (e: Exception) {
            Result.Error(e.toNetworkError())
        }
    }

    private fun parseDateTime(dateString: String): LocalDateTime {
        // Parse "2010-06-04" format
        val parts = dateString.split("-")
        return LocalDateTime(
            year = parts[0].toInt(),
            monthNumber = parts[1].toInt(),
            dayOfMonth = parts[2].toInt(),
            hour = 0,
            minute = 0
        )
    }

    private fun Exception.toNetworkError(): NetworkError {
        return when (this) {
            is SocketTimeoutException -> NetworkError.Timeout
            is RedirectResponseException -> NetworkError.HttpError(
                code = response.status.value,
                message = message
            )

            is ClientRequestException -> NetworkError.HttpError(
                code = response.status.value,
                message = message
            )

            is ServerResponseException -> NetworkError.HttpError(
                code = response.status.value,
                message = message
            )

            else -> NetworkError.Unknown(cause = this)
        }
    }
}