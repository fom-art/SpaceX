package com.fomart.spx.core.model

import kotlinx.datetime.LocalDateTime

data class RocketPreview(
    val id: Int,
    val name: String,
    val firstFlightDate: LocalDateTime
)
