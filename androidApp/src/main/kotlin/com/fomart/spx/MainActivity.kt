package com.fomart.spx

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fomart.spx.ui.App
import com.fomart.spx.core.designsystem.theme.SpaceXTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXTheme {
                App()
            }
        }
    }
}