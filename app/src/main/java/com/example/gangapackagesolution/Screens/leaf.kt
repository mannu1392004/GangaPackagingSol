package com.example.gangapackagesolution.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.dp

@Composable
fun WaveWithGradient() {

    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)) {
        val wavePath = Path().apply {
            moveTo(0f, size.height * 0.5f)
            quadraticBezierTo(
                size.width * 0.25f, size.height * 0.75f,
                size.width * 0.5f, size.height * 0.5f
            )
            quadraticBezierTo(
                size.width * 0.75f, size.height * 0.25f,
                size.width, size.height * 0.5f
            )


            lineTo(size.width, 0f)
            lineTo(0f, 0f)
            close()
        }

        drawPath(
            path = wavePath,
            brush = Brush.linearGradient(
                colors = listOf(Color(0xffEECE13), Color(0xffC54CB4),
                    Color(0xffB210FF)),
                start = Offset(0f, 0f),
                end = Offset(size.width, size.height)
            ),
            style = Fill
        )
    }
}

@Composable
fun BottomWave(modifier: Modifier){
    Canvas(modifier = modifier) {
        val wavePath = Path().apply {
            moveTo(0f, size.height * 0.5f)
            quadraticBezierTo(
                size.width * 0.25f, size.height * 0.55f,
                size.width * 0.5f, size.height * 0.5f
            )
            quadraticBezierTo(
                size.width * 0.65f, size.height * 0.55f,
                size.width, size.height * 0.5f
            )


            lineTo(size.width, 0f)
            lineTo(0f, 0f)
            close()
        }

        drawPath(
            path = wavePath,
            brush = Brush.linearGradient(
                colors = listOf(Color(0xffEECE13), Color(0xffC54CB4),
                    Color(0xffB210FF)),
                start = Offset(0f, 0f),
                end = Offset(size.width, size.height)
            ),
            style = Fill
        )
    }
}