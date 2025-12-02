package com.fomart.spx.core.network.domain

import com.fomart.spx.core.model.RocketPreview

data class PagedRocketPreviewsResult(
    val rocketPreviews: List<RocketPreview>,
    val currentPage: Int,
    val totalPages: Int
)