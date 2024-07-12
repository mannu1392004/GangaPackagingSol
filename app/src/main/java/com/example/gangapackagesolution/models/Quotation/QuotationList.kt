package com.example.gangapackagesolution.models.Quotation

data class QuotationList(
    val customerName: String,
    val quotationNo: String,
    val status: Boolean,
    val from:String,
    val to:String,
    val amount:String,
    val date:String,
    val pickingDate:String,
    val deliveryDate:String,
    val quotationId:String
)
