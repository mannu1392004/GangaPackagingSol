package com.example.gangapackagesolution.Screens.loadingAndErrorScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.gangapackagesolution.ui.theme.lato
import com.example.gangapackagesolution.ui.theme.latosemibold
import com.example.gangapackagesolution.ui.theme.latothin

@Composable
fun ErrorScreen(error:String,onClick:()->Unit){
    Surface() {
        Dialog(onDismissRequest = { onClick() }) {
            Surface(modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = "Error",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.Red
                    ,
                        fontFamily = latosemibold)
                    Text(text = "Something went wrong",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black,
                        fontFamily = latosemibold,
                        textAlign = TextAlign.Center)

                    Button(onClick = { onClick() },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                        ) {
                        Text(text = "Ok")
                    }
                }
            }
        }
    }
}