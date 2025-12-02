package com.fomart.spx.core.model

import kotlinx.datetime.LocalDate

data class RocketPreview(
    val rocketId: String,
    val name: String,
    val firstFlightDate: LocalDate
)
