package com.example.gangapackagesolution.Screens.quotationScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gangapackagesolution.models.Quotation.Quotation
import com.example.gangapackagesolution.models.itemsParticaular.itemParticulars
import com.example.gangapackagesolution.ui.theme.latosemibold

@Composable
fun QuotationScreen(data: Quotation, onlick: (Quotation) -> Unit) {
    val quotationId = remember {
        mutableStateOf(data.id.toString())
    }

    val movingType = remember {
        mutableStateOf("House Hold Goods")
    }

    val companyNameOfParty = remember {
        mutableStateOf(data.companyName)
    }

    val partyName = remember {
        mutableStateOf(data.partyName)
    }


    val email = remember {
        mutableStateOf(data.email)
    }

    val qtDate = remember {
        mutableStateOf(data.date)
    }

    val packingDate = remember {
        mutableStateOf(data.packingDate)
    }


    val shiftingDate = remember {
        mutableStateOf(data.shiftingDate.toString())
    }

    // move from
    val country = remember {
        mutableStateOf(data.country)
    }

    val state = remember {
        mutableStateOf(data.state)
    }

    val city = remember {
        mutableStateOf(data.city)
    }

    val pincode = remember {
        mutableStateOf(
            data.pinCode
        )
    }
    val address = remember {
        mutableStateOf(data.address)
    }

    val floorNo = remember {
        mutableStateOf("")
    }

    // move to
    val country1 = remember {
        mutableStateOf(data.country2)
    }
    val state1 = remember {
        mutableStateOf(data.state2)
    }
    val city1 = remember {
        mutableStateOf(data.city2)
    }
    val pincode1 = remember {
        mutableStateOf(data.pinCode2)
    }
    val address1 = remember {
        mutableStateOf(data.address2)
    }

    // payment details
    val freightCharge = remember {
        mutableStateOf(data.freightCharge)
    }
    val advancePayment = remember {
        mutableStateOf(data.advancePaid)
    }
    val includedPackaging = remember {
        mutableStateOf(data.packingChargeType)
    }

    val packagingCharge = remember {
        mutableStateOf(data.packagingCharge)
    }

    val includedUnPackaging = remember {
        mutableStateOf(data.unpackingChargeType)
    }

    val unPackagingCharge = remember {
        mutableStateOf(data.unpackingCharge)
    }

    val includedLoading = remember {
        mutableStateOf(data.loadingChargeType)
    }
    val loadingCharge = remember {
        mutableStateOf(data.loadingCharge)
    }
    val includedUnLoading = remember {
        mutableStateOf(data.unloadingChargeType)
    }
    val unloadingCharge = remember {
        mutableStateOf(data.unloadingCharge)
    }
    val includedPackingMaterial = remember {
        mutableStateOf(data.packagingMaterialType)
    }
    val packingMaterialCharge = remember {
        mutableStateOf(data.packingMaterialCharge)
    }

    val storageCharge = remember {
        mutableStateOf(data.storageCharge)
    }
    val carbikeTpt = remember {
        mutableStateOf(
            data.carBikeTpt
        )
    }
    val miscCharge = remember {
        mutableStateOf(data.miscelaneousCharge)
    }
    val otherCharge = remember {
        mutableStateOf(data.otherCharge)
    }
    val stCharge = remember {
        mutableStateOf(data.stCharge)
    }
    val octroiGreenTax = remember {
        mutableStateOf(data.octroiGreenTAx)
    }

    val subcharge = remember {
        mutableStateOf(data.subcharges)
    }

    val gst = remember {
        mutableStateOf(data.gst)
    }

    val gstinQuote = remember {
        mutableStateOf(data.gstIn)
    }
    val gstType = remember {
        mutableStateOf(data.gstType)
    }
    val remark = remember {
        mutableStateOf(data.remark)
    }
    val discount = remember {
        mutableStateOf("")
    }


    //insuranceDetails
    val insuranceType = remember {
        mutableStateOf(data.insuranceType)
    }
    val insuranceCharge = remember {
        mutableStateOf(data.insuranceCharge)
    }
    val insuranceGst = remember {
        mutableStateOf(data.gstperc)
    }
    val declarationValueOfGoods = remember {
        mutableStateOf(data.declarationValue)
    }

    // vehicle insurance
    val vehicleInsuranceType = remember {
        mutableStateOf(data.insuranceType1)
    }
    val vehicleInsuranceCharge = remember {
        mutableStateOf(data.insuranceCharge1)
    }
    val vehicleInsuranceGst = remember {
        mutableStateOf(data.gstperc1)
    }
    val vehicleInsuranceDeclarationValueOfVehicle = remember {
        mutableStateOf(data.declarationValue1)
    }

    // other Details
    val isThereEasyAccess = remember {
        mutableStateOf("Yes")
    }

    val shouldAnyItemBeGotDown = remember {
        mutableStateOf("")
    }

    val anyRestrictions = remember {
        mutableStateOf("No")
    }
    val anySpecialConcerns = remember {
        mutableStateOf("")
    }


    // item particulars
    val itemParticulars = remember {

        mutableStateOf<List<itemParticulars>>(emptyList())

    }

    if (data.list[0].item != null) {
        itemParticulars.value = data.list
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(


                color = Color(0xFF673AB7),
            )
    ) {
        Column(

            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            Header("Quotation")
            QuotationForm(
                quotationId,
                movingType,
                companyNameOfParty,
                partyName,
                email,
                qtDate,
                packingDate,
                shiftingDate,
                country,
                state,
                city,
                pincode,
                address,
                floorNo,
                country1,
                state1,
                city1,
                pincode1,
                address1,
                freightCharge,
                advancePayment,
                packagingCharge,
                unPackagingCharge,
                loadingCharge,
                unloadingCharge,
                packingMaterialCharge,
                storageCharge,
                carbikeTpt,
                miscCharge,
                otherCharge,
                stCharge,
                octroiGreenTax,
                gst,
                gstinQuote,
                gstType,
                remark,
                discount,
                subcharge,
                insuranceType,
                insuranceCharge,
                insuranceGst,
                declarationValueOfGoods,
                vehicleInsuranceType,
                vehicleInsuranceCharge,
                vehicleInsuranceGst,
                vehicleInsuranceDeclarationValueOfVehicle,
                isThereEasyAccess,
                shouldAnyItemBeGotDown,
                anyRestrictions,
                anySpecialConcerns,
                itemParticulars,
                includedPackaging,
                includedUnPackaging,
                includedLoading,
                includedUnLoading,
                includedPackingMaterial,
            ) {
                val edited = Quotation(
                    id = quotationId.value.toInt(),
                    companyName = companyNameOfParty.value,
                    partyName = partyName.value,
                    email = email.value,
                    date = qtDate.value,
                    packingDate = packingDate.value,
                    shiftingDate = shiftingDate.value,
                    country = country.value,
                    state = state.value,
                    city = city.value,
                    pinCode = pincode.value,
                    address = address.value,
                    country2 = country1.value,
                    state2 = state1.value,
                    city2 = city1.value,
                    pinCode2 = pincode1.value,
                    address2 = address1.value,
                    freightCharge = freightCharge.value,
                    advancePaid = advancePayment.value,
                    packagingCharge = packagingCharge.value,
                    unpackingCharge = unPackagingCharge.value,
                    loadingCharge = loadingCharge.value,
                    unloadingCharge = unloadingCharge.value,
                    packingMaterialCharge = packingMaterialCharge.value,
                    storageCharge = storageCharge.value,
                    carBikeTpt = carbikeTpt.value,
                    miscelaneousCharge = miscCharge.value,
                    otherCharge = otherCharge.value,
                    stCharge = stCharge.value,
                    octroiGreenTAx = octroiGreenTax.value,
                    gst = gst.value,
                    gstIn = gstinQuote.value,
                    gstType = gstType.value,
                    remark = remark.value,
                    subcharges = subcharge.value,
                    insuranceType = insuranceType.value,
                    insuranceCharge = insuranceCharge.value,
                    gstperc = insuranceGst.value,
                    declarationValue = declarationValueOfGoods.value,
                    insuranceType1 = vehicleInsuranceType.value,
                    insuranceCharge1 = vehicleInsuranceCharge.value,
                    gstperc1 = vehicleInsuranceGst.value,
                    declarationValue1 = vehicleInsuranceDeclarationValueOfVehicle.value,
                    list = itemParticulars.value,
                    areAnyRestrictionLoading = anyRestrictions.value,
                    discount = discount.value,
                    doesAnySpecialNeedsOrConcerns = anySpecialConcerns.value,
                    phoneNumber = data.phoneNumber,
                    qtdate = qtDate.value,
                    packagingMaterialType = includedPackingMaterial.value,
                    unpackingChargeType = includedUnPackaging.value,
                    loadingChargeType = includedLoading.value,
                    unloadingChargeType = includedUnLoading.value,
                    packingChargeType = includedPackaging.value,
                    total = data.total,
                    status = data.status,
                    easyAccessForLoading = isThereEasyAccess.value,
                    shouldAnyItemGotDown = shouldAnyItemBeGotDown.value,
                    markAsPAid = data.markAsPAid,
                    movingType = movingType.value,
                    subchargeType = subcharge.value


                )

                onlick(edited)

            }


        }
    }

}


@Composable
fun Header(text: String) {

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color.Transparent,

        ) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(
                imageVector = Icons.Default.ArrowBack, contentDescription = "",
                tint = Color.White, modifier = Modifier.padding(start = 10.dp)
            )

            Text(
                text = text,
                fontFamily = latosemibold,
                modifier = Modifier.padding(top = 20.dp, bottom = 15.dp, start = 20.dp),
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
        }
    }

}
