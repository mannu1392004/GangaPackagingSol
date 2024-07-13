package com.example.gangapackagesolution.models

import android.adservices.common.AdData
import java.io.IOException
import java.lang.Exception
data class DataOrException<T, E: Exception>(
    var data: T? = null,
    var loading:Boolean = false,
    var e: E? = null
)