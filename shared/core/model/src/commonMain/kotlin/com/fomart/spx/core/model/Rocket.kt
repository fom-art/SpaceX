package com.fomart.spx.core.model

data class Rocket(
    val rocketId: String,
    val description: String,

    val height: Int,
    val diameter: Int,
    val massKg: Int,

    val stages: List<Stage>,
    val photoLinks: List<String>
) {
    val massTonn = massKg / 1000
}
