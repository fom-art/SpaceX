package com.fomart.spx.core.network.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class MassDto(
    val kg: Int,
    val lb: Int
)