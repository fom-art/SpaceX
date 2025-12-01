package com.fomart.spx.navigation

import AppStateStore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.fomart.spx.shared.feature.catalog.all.search.navigation.navigateToSearch
import com.fomart.spx.shared.feature.catalog.all.search.navigation.searchScreen
import com.fomart.spx.shared.feature.catalog.navigation.CatalogScreen
import com.fomart.spx.shared.feature.catalog.navigation.catalogScreen
import com.fomart.spx.shared.feature.character_details.navigation.characterDetailsScreen
import com.fomart.spx.shared.feature.character_details.navigation.navigateToCharacterDetails
import com.fomart.spx.shared.feature.favorites.navigation.favoritesScreen

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
            navigateToCharacterDetails = navController::navigateToCharacterDetails,
            navigateToSearch = navController::navigateToSearch
        )
        characterDetailsScreen(navigateBack = navController::navigateUp)
        favoritesScreen(
            navigateToCharacterDetails = navController::navigateToCharacterDetails
        )
        searchScreen(
            navigateToCharacterDetails = navController::navigateToCharacterDetails,
            navigateBack = navController::navigateUp
        )
    }
}