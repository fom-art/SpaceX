package com.fomart.spx.core.network.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RocketDto(
    val id: Int,
    @SerialName("rocket_id") val rocketId: String,
    @SerialName("rocket_name") val rocketName: String,
    @SerialName("first_flight") val firstFlight: String,
    val description: String,
    val height: DimensionDto,
    val diameter: DimensionDto,
    val mass: MassDto,
    @SerialName("first_stage") val firstStage: FirstStageDto? = null,
    @SerialName("second_stage") val secondStage: SecondStageDto? = null,
    @SerialName("flickr_images") val flickrImages: List<String>
)