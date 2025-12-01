package com.fomart.spx.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import spacex.shared.core.designsystem.generated.resources.AzeretMono_VariableFont_wght
import spacex.shared.core.designsystem.generated.resources.Montserrat_SemiBold
import spacex.shared.core.designsystem.generated.resources.Res

@OptIn(ExperimentalResourceApi::class)
@Composable
fun bodyFontFamily() = FontFamily(
    Font(Res.font.Montserrat_SemiBold) // static or variable? Either works
)

@OptIn(ExperimentalResourceApi::class)
@Composable
fun displayFontFamily() = FontFamily(
    Font(Res.font.AzeretMono_VariableFont_wght) // variable font → one entry is enough
)


@Composable
fun appTypography() = Typography().run {
    val display = displayFontFamily()
    val body = bodyFontFamily()

    copy(
        // Display styles
        displayLarge = displayLarge.copy(fontFamily = display),
        displayMedium = displayMedium.copy(fontFamily = display),
        displaySmall = displaySmall.copy(fontFamily = display),

        headlineLarge = headlineLarge.copy(fontFamily = display),
        headlineMedium = headlineMedium.copy(fontFamily = display),
        headlineSmall = headlineSmall.copy(fontFamily = display),

        titleLarge = titleLarge.copy(fontFamily = display),
        titleMedium = titleMedium.copy(fontFamily = display),
        titleSmall = titleSmall.copy(fontFamily = display),

        // Body styles
        bodyLarge = bodyLarge.copy(fontFamily = body),
        bodyMedium = bodyMedium.copy(fontFamily = body),
        bodySmall = bodySmall.copy(fontFamily = body),

        // Labels
        labelLarge = labelLarge.copy(fontFamily = body),
        labelMedium = labelMedium.copy(fontFamily = body),
        labelSmall = labelSmall.copy(fontFamily = body),
    )
}