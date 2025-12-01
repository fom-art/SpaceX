package com.fomart.spx

import androidx.compose.ui.window.ComposeUIViewController
import com.fomart.spx.ui.App
import com.fomart.spx.core.designsystem.theme.SpaceXTheme

fun MainViewController() = ComposeUIViewController {
    SpaceXTheme {
        App()
    }
}