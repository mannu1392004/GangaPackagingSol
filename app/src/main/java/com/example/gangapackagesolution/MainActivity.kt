package com.example.gangapackagesolution

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gangapackagesolution.Screens.homeScreen.HomeScreen
import com.example.gangapackagesolution.Screens.quotationScreen.QuotationMainScreen
import com.example.gangapackagesolution.ui.theme.GangaPackageSolutionTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GangaPackageSolutionTheme {
                QuotationMainScreen()
            }
        }
    }
}

