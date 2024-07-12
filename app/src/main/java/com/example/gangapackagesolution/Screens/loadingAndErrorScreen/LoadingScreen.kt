package com.example.gangapackagesolution.Screens.loadingAndErrorScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun LoadingScreen(color: Color,
                  indicatorColor: Color){
    Surface(modifier = Modifier.fillMaxSize(),
        color = color) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment =  Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                color = indicatorColor
            )
        }
    }
}