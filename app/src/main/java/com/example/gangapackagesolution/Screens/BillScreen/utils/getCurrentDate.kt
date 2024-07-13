package com.example.gangapackagesolution.Screens.BillScreen.utils

import android.icu.util.Calendar

fun getCurrentDate(): String {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    return "$year-${month + 1}-$day"
}