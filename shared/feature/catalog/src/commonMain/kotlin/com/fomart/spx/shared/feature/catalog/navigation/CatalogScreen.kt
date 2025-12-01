package com.fomart.spx.shared.feature.catalog.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.fomart.spx.shared.feature.catalog.presentation.CatalogScreen
import kotlinx.serialization.Serializable

@Serializable
data object CatalogScreen

fun NavController.navigateToCatalog(
    navOptions: NavOptions? = null
) = navigate(CatalogScreen, navOptions)

fun NavGraphBuilder.catalogScreen(
    navigateToCharacterDetails: (String) -> Unit,
    navigateToSearch: () -> Unit,
) {
    composable<CatalogScreen> {
        CatalogScreen(
            navigateToCharacterDetails = navigateToCharacterDetails,
            navigateToSearch = navigateToSearch
        )
    }
}
