package com.fomart.spx.ui.navigation

import AppStateStore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.fomart.spx.shared.feature.catalog.navigation.CatalogScreen
import com.fomart.spx.shared.feature.catalog.navigation.catalogScreen

@Composable
fun SpxNavHost(
    modifier: Modifier = Modifier,
    appState: AppStateStore,
    onShowSnackbar: suspend (String, String?) -> Boolean,
) {
    val navController = appState.navController

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = CatalogScreen,
    ) {
        catalogScreen(
            navigateToCharacterDetails = {},
        )
    }
}