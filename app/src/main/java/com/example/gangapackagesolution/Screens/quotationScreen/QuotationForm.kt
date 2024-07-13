package com.example.gangapackagesolution.Screens.quotationScreen

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.util.Log
import android.widget.DatePicker
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.gangapackagesolution.data.Data
import com.example.gangapackagesolution.models.itemsParticaular.itemParticulars
import com.example.gangapackagesolution.ui.theme.latosemibold

@Composable
fun QuotationForm(
    quotationId: MutableState<String>,
    movingType: MutableState<String>,
    companyNameOfParty: MutableState<String>,
    partyName: MutableState<String>,
    email: MutableState<String>,
    selectedDate: MutableState<String>,
    packingDate: MutableState<String>,
    shiftingDate: MutableState<String>,
    country: MutableState<String>,
    state: MutableState<String>,
    city: MutableState<String>,
    pincode: MutableState<String>,
    address: MutableState<String>,
    floorNo: MutableState<String>,
    country1: MutableState<String>,
    state1: MutableState<String>,
    city1: MutableState<String>,
    pincode1: MutableState<String>,
    address1: MutableState<String>,
    freightCharge: MutableState<String>,
    advancePayment: MutableState<String>,
    packagingCharge: MutableState<String>,
    unPackagingCharge: MutableState<String>,
    loadingCharge: MutableState<String>,
    unloadingCharge: MutableState<String>,
    packingMaterialCharge: MutableState<String>,
    storageCharge: MutableState<String>,
    carbikeTpt: MutableState<String>,
    miscCharge: MutableState<String>,
    otherCharge: MutableState<String>,
    stCharge: MutableState<String>,
    octroiGreenTax: MutableState<String>,
    gst: MutableState<String>,
    gstinQuote: MutableState<String>,
    gstType: MutableState<String>,
    remark: MutableState<String>,
    discount: MutableState<String>,
    subcharge: MutableState<String>,
    insuranceType: MutableState<String>,
    insuranceCharge: MutableState<String>,
    insuranceGst: MutableState<String>,
    declarationValueOfGoods: MutableState<String>,
    vehicleInsuranceType: MutableState<String>,
    vehicleInsuranceCharge: MutableState<String>,
    vehicleInsuranceGst: MutableState<String>,
    vehicleInsuranceDeclarationValueOfVehicle: MutableState<String>,
    isThereEasyAccess: MutableState<String>,
    shouldAnyItemBeGotDown: MutableState<String>,
    anyRestrictions: MutableState<String>,
    anySpecialConcerns: MutableState<String>,
    itemParticulars: MutableState<List<itemParticulars>>,
     includedPacking: MutableState<String>,
    includedUnPackaging: MutableState<String>,
    includedLoading: MutableState<String>,
    includedUnLoading: MutableState<String>,
    includedPackingMaterial: MutableState<String>,

onlick: () -> Unit
    ) {

    val showQuotationDetails = remember {
        mutableStateOf(true)
    }

    val showMoveFromDetails = remember {
        mutableStateOf(false)
    }

    val showMoveTODetails = remember {
        mutableStateOf(false)
    }

    val showPaymentDetails = remember {
        mutableStateOf(false)
    }

    val showInsuranceDetails = remember {
        mutableStateOf(false)
    }

    val showVehicleInsuranceDetails = remember {
        mutableStateOf(false)
    }

    val showOtherDetails = remember {
        mutableStateOf(false)
    }
    val showItemDetails = remember {
        mutableStateOf(false)
    }
    val itemname = remember {
        mutableStateOf("")
    }
    val quantity = remember {
        mutableStateOf("")
    }

    val value = remember {
        mutableStateOf("")
    }
    val itemremark = remember {
        mutableStateOf("")
    }


    val data = Data()

    Column(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp),

        ) {

        TitleDefiner(s = "1.) Quotation Details", showMoveFromDetails = showQuotationDetails)

        if (showQuotationDetails.value) {
            // making the field for the quotation no
            RegularField(quotationId, true, "Quotation Id")

            // making the optional field
            OptionsField("Moving Type", data.movingType, movingType)

            // company name
            RegularField(companyNameOfParty, false, "Company Name")

            // party name
            RegularField(partyName, false, "Party Name")

            // email
            RegularField(email, false, "Email")

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

// date selector
                DateSelector(
                    selectedDate, modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    "Q.T Date"
                )

                Spacer(modifier = Modifier.weight(0.2f))

                DateSelector(
                    selectedDate = packingDate, modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(), s = "Packaging Date"
                )

            }

            DateSelector(
                selectedDate = shiftingDate, modifier = Modifier
                    .fillMaxWidth(), s = "Shifting Date"
            )


        }
        HorizontalDivider()
        // second

        TitleDefiner("2.) MoveFrom", showMoveFromDetails)

        if (showMoveFromDetails.value) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RegularField(
                    country, false, "Country",
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.width(15.dp))
                RegularField(
                    state, false, "State",
                    modifier = Modifier
                )

            }
            RegularField(city, false, "City")
            RegularField(pincode, false, "Pincode")
            RegularField(address, false, "Address")
        }
        HorizontalDivider()


        // 3rd
        TitleDefiner(s = "3.) Move To", showMoveFromDetails = showMoveTODetails)

        if (showMoveTODetails.value) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RegularField(
                    country1, false, "Country",
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.width(15.dp))
                RegularField(
                    state1, false, "State",
                    modifier = Modifier
                )

            }
            RegularField(city1, false, "City")
            RegularField(pincode1, false, "Pincode")
            RegularField(address1, false, "Address")
        }
        HorizontalDivider()

        // payment
        TitleDefiner(s = "4.) Payment", showMoveFromDetails = showPaymentDetails)

        if (showPaymentDetails.value) {

            RegularField(
                quotationId = freightCharge, s = "Freight Charge",
                type = false
            )
            RegularField(
                quotationId = advancePayment, s = "Advance Payment",
                type = false
            )

            SpecialField("Packing Charge", packagingCharge, included =includedPacking )
            SpecialField(s = "Un Packaging Charge", packagingCharge = unPackagingCharge, included = includedUnPackaging)
            SpecialField(s = "Loading Charge", packagingCharge = loadingCharge, included = includedLoading)
            SpecialField(s = "Unloading Charge", packagingCharge = unloadingCharge, included = includedUnLoading)
            SpecialField(s = "Packing Material Charge", packagingCharge = packingMaterialCharge, included = includedPackingMaterial)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RegularField(
                    storageCharge, false, "Storage Charge",
                    modifier = Modifier,
                    type = false
                )
                Spacer(modifier = Modifier.width(15.dp))
                RegularField(
                    carbikeTpt, false, "Car/Bike TPT",
                    modifier = Modifier,
                    type = false
                )

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RegularField(
                    miscCharge, false, "MISC. Charge",
                    modifier = Modifier,
                    type = false
                )
                Spacer(modifier = Modifier.width(15.dp))
                RegularField(
                    otherCharge, false, "Other Charge",
                    modifier = Modifier,
                    type = false
                )

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RegularField(
                    stCharge, false, "S.T Charge",
                    modifier = Modifier,
                    type = false
                )
                Spacer(modifier = Modifier.width(15.dp))
                RegularField(
                    octroiGreenTax, false, "OCTROI Green Tax",
                    modifier = Modifier,
                    type = false
                )

            }
            OptionsField(movingType1 = "SurCharge (%)", movingType = data.subCharge, subcharge)

            OptionsField(
                movingType1 = "GST(In Quote/By Bill)",
                movingType = data.gst,
                subcharge = gstinQuote
            )
            if (gstinQuote.value == "In Quotation" || gstinQuote.value == "By Bill" || gstinQuote.value == "Extra") {
                OptionsField(movingType1 = "Gst%", movingType = data.gstperc, subcharge = gst)
                OptionsField(
                    movingType1 = "GST Type",
                    movingType = data.gstType,
                    subcharge = gstType
                )
            }
            RegularField(remark, false, "Remark")
            RegularField(
                discount, false, "Discount",
                type = false
            )

        }
        HorizontalDivider()

        TitleDefiner(s = "5.) Insurance (Fov) Details", showMoveFromDetails = showInsuranceDetails)
        if (
            showInsuranceDetails.value
        ) {
            OptionsField(
                movingType1 = "Insurance Type",
                movingType = data.insuranceType,
                subcharge = insuranceType
            )
            if (insuranceType.value != "Not Applicable") {
                OptionsField(
                    movingType1 = "Insurance Charge",
                    movingType = data.insuranceCharge,
                    subcharge = insuranceCharge
                )

                OptionsField(
                    movingType1 = "Gst",
                    movingType = data.gstType,
                    subcharge = insuranceGst
                )
                RegularField(declarationValueOfGoods, false, "Declaration Value Of Goods")
            }

        }



        HorizontalDivider()

        // vehicle insurance
        TitleDefiner(
            s = "6.) Vehicle Insurance Details",
            showMoveFromDetails = showVehicleInsuranceDetails
        )
        if (showVehicleInsuranceDetails.value) {

            OptionsField(
                movingType1 = "Insurance Type", movingType = data.insuranceType,
                subcharge = vehicleInsuranceType
            )

            if (vehicleInsuranceType.value != "Not Applicable") {
                OptionsField(
                    movingType1 = "Insurance Charge",
                    movingType = data.insuranceCharge,
                    subcharge = vehicleInsuranceCharge
                )
                OptionsField(
                    movingType1 = "Gst",
                    movingType = data.gstType,
                    subcharge = vehicleInsuranceGst
                )
                RegularField(declarationValueOfGoods, false, "Declaration Value Of Vehicle")
            }

        }
        HorizontalDivider()

        // other details
        TitleDefiner(
            s = "7.) Other Details",
            showMoveFromDetails = showOtherDetails
        )
        if (showOtherDetails.value) {
            OptionsField(
                movingType1 = "Is There Easy Access",
                movingType = data.yesNo,
                subcharge = isThereEasyAccess
            )
            RegularField(
                quotationId = shouldAnyItemBeGotDown,
                s = "Should any item be got down through balcony etc Ex-Bed,Almira etc"
            )

            OptionsField(
                movingType1 = "Are there any restrictions for loading/unloading?",
                movingType = data.yesNo,
                subcharge = anyRestrictions
            )
        }

        HorizontalDivider()

        TitleDefiner(s = "8.) Item Details", showMoveFromDetails = showItemDetails)

        if (showItemDetails.value) {
            RegularField(quotationId = itemname, s = "Item Name")

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RegularField(
                    quantity, false, "Quantity",
                    modifier = Modifier,
                    type = false
                )
                Spacer(modifier = Modifier.width(15.dp))
                RegularField(
                    value, false, "value",
                    modifier = Modifier,
                    type = false
                )

            }
            RegularField(itemremark, false, "Remark")
            Spacer(modifier = Modifier.height(10.dp))
            CustomButton("Save Item") {
                if (
                    !itemParticulars.value.contains(
                        itemParticulars(
                            itemname.value,
                            quantity.value,
                            value.value,
                            itemremark.value
                        )
                    )
                ) {
                    itemParticulars.value += itemParticulars(
                        itemname.value,
                        quantity.value,
                        value.value,
                        itemremark.value
                    )
                }

            Log.d("list to saveeeee",itemParticulars.value.toString())
            }
            Spacer(modifier = Modifier.height(10.dp))

            ShowAndRemoveItems(itemParticulars = itemParticulars)
        }



        HorizontalDivider()


        Spacer(modifier = Modifier.height(20.dp))

        CustomButton("Submit Quotation") {
            onlick()
        }




        Spacer(modifier = Modifier.height(20.dp))


    }
}

@Composable
fun ShowAndRemoveItems(itemParticulars: MutableState<List<itemParticulars>>) {
    if (!itemParticulars.value.isEmpty())
        Surface(
            color = Color.Transparent
        ) {


            LazyColumn(modifier = Modifier.height(200.dp)) {
                items(itemParticulars.value) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp), shape = RoundedCornerShape(10.dp),
                        color = Color.Transparent,
                        border = BorderStroke(width = 1.dp, color = Color.White)
                    ) {
                        Column {


                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = it.itemName,
                                    color = Color.White,
                                    modifier = Modifier.weight(1f)
                                )

                                Icon(
                                    imageVector = Icons.Default.Delete, contentDescription = "",
                                    modifier = Modifier.clickable {
                                        itemParticulars.value =
                                            itemParticulars.value.filter { item ->
                                                item != it
                                            }
                                    },
                                    tint = Color.White
                                )

                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "Quantity :${it.quantity}", color = Color.White)
                                Text(text = "Value :${it.value}", color = Color.White)
                            }
                            if (it.remark != "") {
                                Text(text = "Remark :${it.remark}", color = Color.White)
                            }

                        }
                    }
                }
            }
        }
}

@Composable
fun CustomButton(onItemClick1: String, onItemClick: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp),
        color = Color(0xFF17FF20)
    ) {
        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier.clickable {
                onItemClick()
            }) {
            Text(
                text = onItemClick1,
                modifier = Modifier.padding(10.dp),
                color = Color(0xFF673AB7)
            )
        }
    }
}

@Composable
fun SpecialField(s: String, packagingCharge: MutableState<String>, data: Data = Data(),included: MutableState<String> ) {

    val showDialogue = remember {
        mutableStateOf(false)
    }

    val include = remember {
        mutableStateOf(false)
    }

    if (included.value == "Additional from Freight") {
        include.value = true
    } else {
        packagingCharge.value = "0"
        include.value = false
    }



    Column {

        Text(
            text = s,
            color = Color.White
        )

        Row {
            // option Selection
            Surface(
                modifier = Modifier.clickable {
                    showDialogue.value = !showDialogue.value
                },
                shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp)
            ) {
                Text(
                    text = included.value + " :",
                    modifier = Modifier.padding(10.dp)
                )
                DropdownMenu(expanded = showDialogue.value, onDismissRequest = {
                    showDialogue.value = !showDialogue.value
                }) {
                    data.includingType.forEach {
                        Surface(modifier = Modifier
                            .padding(10.dp)
                            .height(44.dp)
                            .fillMaxWidth()
                            .clickable {
                                included.value = it
                                showDialogue.value = !showDialogue.value
                            }) {
                            Text(text = it, modifier = Modifier)
                        }
                    }
                }


            }

            VerticalDivider()

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp),
                color = Color.White,
                shape = RoundedCornerShape(
                    bottomEnd = 10.dp,
                    topEnd = 10.dp
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    BasicTextField(
                        value = packagingCharge.value, onValueChange = {
                            if (!it.contains(",") && it.count { char ->
                                    char == '.'
                                } <= 1 && it != ".") {
                                packagingCharge.value = it
                            }
                        }, textStyle = TextStyle(fontSize = 20.sp),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                        enabled = include.value
                    )
                }
            }
        }
    }
}

@Composable
fun TitleDefiner(s: String, showMoveFromDetails: MutableState<Boolean>) {


    Row(modifier = Modifier.clickable {
        showMoveFromDetails.value = !showMoveFromDetails.value
    }) {


        Text(
            text = s,
            fontFamily = latosemibold,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )

        Icon(
            imageVector = if (!showMoveFromDetails.value) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
            contentDescription = "",
            modifier = Modifier
                .size(30.dp),
            tint = Color.White
        )

    }
}

@Composable
fun DateSelector(selectedDate: MutableState<String>, modifier: Modifier, s: String) {
    val context = LocalContext.current

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
            selectedDate.value = "$selectedYear-${selectedMonth + 1}-$selectedDay"
        }, year, month, day
    )


    Column(modifier = modifier.clickable {
        datePickerDialog.show()
    }) {

        Text(text = s, color = Color.White)

        Surface(
            modifier = modifier, shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = selectedDate.value,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}


@Composable
fun OptionsField(
    movingType1: String,
    movingType: List<String>,
    subcharge: MutableState<String>,
) {


    val openDialod = remember {
        mutableStateOf(false)

    }
    Column {

        Text(
            text = movingType1,
            color = Color.White
        )
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    openDialod.value = true
                },
            shape = RoundedCornerShape(10.dp),
            shadowElevation = 10.dp
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(12.dp)
            ) {
                Text(text = subcharge.value)

                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")

            }
        }
    }

    if (openDialod.value) {
        Dialog(onDismissRequest = { }) {
            Surface(shape = RoundedCornerShape(10.dp)) {
                LazyColumn(modifier = Modifier.padding(10.dp)) {

                    items(movingType) {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    subcharge.value = it
                                    openDialod.value = false
                                },
                            color = if (it == subcharge.value) Color.LightGray else Color.White
                        ) {
                            HorizontalDivider()
                            Text(text = it, modifier = Modifier.padding(10.dp))
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun RegularField(
    quotationId: MutableState<String>,
    b: Boolean = false,
    s: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    type: Boolean = true
) {

    Column() {

        Text(
            text = s,
            color = Color.White
        )
        Surface(
            modifier = modifier, color = Color.White,
            shape = RoundedCornerShape(10.dp),

            ) {
            if (type) {
                BasicTextField(
                    value = quotationId.value,
                    onValueChange = { quotationId.value = it }, readOnly = b,
                    textStyle = TextStyle(fontSize = 20.sp),
                    modifier = Modifier.padding(10.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        KeyboardCapitalization.Words
                    )
                )

            } else {
                BasicTextField(
                    value = quotationId.value, onValueChange = {
                        if (!it.contains(",") && it.count { char ->
                                char == '.'
                            } <= 1 && it != ".") {
                            quotationId.value = it
                        }

                    },
                    modifier = Modifier.padding(10.dp), textStyle = TextStyle(fontSize = 20.sp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                )
            }
        }
    }
}

