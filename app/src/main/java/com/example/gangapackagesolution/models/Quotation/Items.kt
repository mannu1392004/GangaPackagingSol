package com.example.gangapackagesolution.models.Quotation

import kotlinx.serialization.Serializable

@Serializable
data class Items(
    val itemName: String,
    val quantity: String,
    val remark: String,
    val value: String
)