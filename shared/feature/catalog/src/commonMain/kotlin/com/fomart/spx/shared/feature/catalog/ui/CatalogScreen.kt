package com.fomart.spx.shared.feature.catalog.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.fomart.spx.core.designsystem.components.DefaultTopBar
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import spacex.shared.feature.catalog.generated.resources.Res
import spacex.shared.feature.catalog.generated.resources.rockets

@Composable
fun CatalogScreen(
    modifier: Modifier = Modifier,
    viewModel: CatalogViewModel = koinViewModel(),
    navigateToRocketDetails: (id: String) -> Unit,
) {
    val state = viewModel.catalogState.collectAsState().value
    Scaffold(
        modifier = modifier,
        topBar = {
            DefaultTopBar(
                title = stringResource(Res.string.rockets)
            )
        }
    ) { innerPadding ->

    }
}