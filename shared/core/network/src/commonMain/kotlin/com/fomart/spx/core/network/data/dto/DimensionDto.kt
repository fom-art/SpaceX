package com.fomart.spx.core.network.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class DimensionDto(
    val meters: Double?,
    val feet: Double?
)
