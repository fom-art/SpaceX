package com.fomart.spx.ui.navigation

import com.fomart.spx.core.model.ui.UiImageVector
import com.fomart.spx.core.model.ui.UiText
import kotlin.reflect.KClass

sealed class TopLevelDestination(
    val selectedIcon: UiImageVector,
    val unselectedIcon: UiImageVector,
    val iconUiText: UiText,
    val screenRoute: KClass<*>,
) {

    companion object {
        val entries: List<TopLevelDestination> = emptyList()
    }
}