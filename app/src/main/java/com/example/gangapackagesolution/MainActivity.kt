package com.example.gangapackagesolution

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gangapackagesolution.Screens.MainViewModel
import com.example.gangapackagesolution.Screens.nav.MainNav
import com.example.gangapackagesolution.Screens.quotationScreen.quotationShow.QuotationListShow
import com.example.gangapackagesolution.ui.theme.GangaPackageSolutionTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GangaPackageSolutionTheme {
                MainNav(context = this)
                
            }
        }
    }
}

