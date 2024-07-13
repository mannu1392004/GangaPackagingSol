package com.example.gangapackagesolution

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.gangapackagesolution.Screens.nav.MainNav
import com.example.gangapackagesolution.ui.theme.GangaPackageSolutionTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChangeStatusBarColor()

            GangaPackageSolutionTheme {
                MainNav(context = this)
            }
        }
    }
}

@Composable
fun ChangeStatusBarColor() {
    val systemUiController = rememberSystemUiController()


    systemUiController.setSystemBarsColor(
        color = Color(0xFF673AB7), // Change to your desired color
        darkIcons = false,
    )
}

