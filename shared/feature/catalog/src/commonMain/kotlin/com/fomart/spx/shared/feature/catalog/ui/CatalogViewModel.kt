package com.fomart.spx.shared.feature.catalog.ui

import androidx.lifecycle.ViewModel
import com.fomart.spx.core.model.RocketPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CatalogViewModel() : ViewModel() {
    private val _catalogState = MutableStateFlow(CatalogState())
    val catalogState = _catalogState.asStateFlow()

    data class CatalogState(
        val charactersPreviewsRaw: List<RocketPreview> = emptyList()
    )
}