package com.fomart.spx.core.network.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FirstStageDto(
    val reusable: Boolean,
    val engines: Int,
    @SerialName("fuel_amount_tons") val fuelAmountTons: Double,
    @SerialName("burn_time_sec") val burnTimeSec: Int?
)
