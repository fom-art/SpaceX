package com.fomart.spx.shared.feature.catalog.presentation

import CharactersPreviewsList
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.fomart.spx.core.designsystem.components.DefaultTopBar
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CatalogScreen(
    modifier: Modifier = Modifier,
    viewModel: CatalogViewModel = koinViewModel(),
    navigateToCharacterDetails: (id: String) -> Unit,
    navigateToSearch: () -> Unit,
) {
    val state = viewModel.catalogState.collectAsState().value
    Scaffold(
        modifier = modifier,
        topBar = {
            DefaultTopBar(
                title = stringResource(),
                trailingIcon = {

                }
            )
        }
    ) { innerPadding ->
        CharactersPreviewsList(
            modifier = Modifier.padding(innerPadding),
            charactersPreviews = state.charactersPreviews,
            searchMode = false,
            onSelectCharacter = { characterPreview -> navigateToCharacterDetails(characterPreview.id) },
            canLoadMode = !state.isLastPageLoaded,
            loadMore = viewModel::loadNextPage
        )
    }
}