package com.fomart.spx.shared.feature.catalog.all.search.domain

import com.fomart.spx.core.model.CharacterPreview

data class SearchState(
    val filter: String = "",
    val expanded: Boolean = false,
    val filteredCharacters: List<CharacterPreview> = emptyList(),
    val lastPageLoaded: Int = 0,
    val totalPages: Int = 0
) {
    val isLastPageLoaded: Boolean get() = lastPageLoaded >= totalPages
}