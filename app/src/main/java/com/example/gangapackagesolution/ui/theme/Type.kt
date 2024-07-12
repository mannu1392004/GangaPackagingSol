package com.example.gangapackagesolution.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.gangapackagesolution.R

// Set of Material typography styles to start with
val Typography = Typography(
        bodyLarge = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
        )
        /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
val lato = FontFamily(
        Font(R.font.latobold,FontWeight.Bold),
        Font(R.font.latothin),
        Font(R.font.latoblack),
        Font(R.font.latoregular),
        Font(R.font.llatothin),

)
val latothin = FontFamily(
        Font(R.font.latothin)
)
val latolight = FontFamily(
        Font(R.font.latoregular)
)
val latosemibold = FontFamily(
        Font(R.font.latobold)
)

