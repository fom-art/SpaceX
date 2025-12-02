package com.fomart.spx.shared.feature.catalog.ui.components

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fomart.spx.core.designsystem.theme.SpaceXTheme
import com.fomart.spx.core.model.RocketPreview
import kotlinx.datetime.LocalDate
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import spacex.shared.feature.catalog.generated.resources.Res
import spacex.shared.feature.catalog.generated.resources.rocket

@Composable
fun RocketPreviewItem(
    modifier: Modifier = Modifier,
    rocketPreview: RocketPreview
) {
    ListItem(
        modifier = modifier.background(MaterialTheme.colorScheme.primary),
        leadingContent = {
            Icon(
                imageVector = vectorResource(Res.drawable.rocket),
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = null
            )
        },
        headlineContent = {
            Text(text = rocketPreview.name)
        },
        supportingContent = {
            Text(text = rocketPreview.firstFlightDate.toString())
        }
    )
}

@Preview
@Composable
fun RocketPreviewItemPreview() {
    SpaceXTheme {
        RocketPreviewItem(
            rocketPreview = RocketPreview(
                rocketId = "rocket",
                name = "Very cool rocket",
                firstFlightDate = LocalDate(2010, 6, 4)
            )
        )
    }
}