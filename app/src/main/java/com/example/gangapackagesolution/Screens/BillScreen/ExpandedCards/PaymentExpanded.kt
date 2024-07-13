package com.example.gangapackagesolution.Screens.BillScreen.ExpandedCards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gangapackagesolution.Screens.BillScreen.Components.ExtendedField
import com.example.gangapackagesolution.Screens.BillScreen.Components.OptionsField
import com.example.gangapackagesolution.Screens.BillScreen.Components.RegularField
import com.example.gangapackagesolution.data.Data

@Composable
fun PaymentExpanded(modifier: Modifier = Modifier) {
    val data = Data()
    val freightChargeState = remember {
        mutableStateOf("")
    }
    val advancePaidState = remember {
        mutableStateOf("")
    }
    val packingChargeState = remember {
        mutableStateOf("")
    }
    val selectedPackageCharge = remember {
        mutableStateOf("${data.includingType[0]}")
    }
    val selectedUnpackingCharge = remember {
        mutableStateOf("${data.includingType[0]}")
    }
    val unPackingChargeState = remember {
        mutableStateOf("0")
    }
    val selectedLoadingCharge = remember {
        mutableStateOf("${data.includingType[0]}")
    }
    val loadingChargeState = remember {
        mutableStateOf("0")
    }
    val selectedUnloadingCharge = remember {
        mutableStateOf("${data.includingType[0]}")
    }
    val unLoadingChargeState = remember {
        mutableStateOf("0")
    }
    val selectedPackingMaterialCharge = remember {
        mutableStateOf("${data.includingType[0]}")
    }
    val packingMaterialChargeState = remember {
        mutableStateOf("0")
    }
    val storageChargeState = remember {
        mutableStateOf("0")
    }
    val vehicleTPTState = remember {
        mutableStateOf("0")
    }
    val miscChargeState = remember {
        mutableStateOf("0")
    }
    val otherChargeState = remember {
        mutableStateOf("0")
    }
    val stChargeState = remember {
        mutableStateOf("0")
    }
    val greenTaxState = remember {
        mutableStateOf("0")
    }
    val selectedGstIN_EX = remember {
        mutableStateOf(data.gstIn_ExList[0])
    }
    val selectedGstPercentage = remember {
        mutableStateOf(data.gstperc[3])
    }
    val selectedGstType = remember {
        mutableStateOf(data.gstType[0])
    }
    val selectedReverseCharge = remember {
        mutableStateOf(data.yesNo[1])
    }
    val selectedGstPaidBy = remember {
        mutableStateOf(data.gstPaidByList[2])
    }
    val discountState = remember {
        mutableStateOf("")
    }
    val paymentRemarkState = remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        RegularField(
            stateHolder = freightChargeState,
            title = "FREIGHT CHARGE",
            wordType = false
        )
        RegularField(
            stateHolder = advancePaidState,
            title = "ADVANCED PAID",
            wordType = false
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                OptionsField(
                    title = "PACKING CHARGE",
                    optionList = data.includingType,
                    selectedValue = selectedPackageCharge,
                )
            }
            Spacer(modifier = Modifier.weight(0.07f))
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                RegularField(
                    stateHolder = packingChargeState,
                    wordType = false
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                OptionsField(
                    title = "UNPACKING CHARGE",
                    optionList = data.includingType,
                    selectedValue = selectedPackageCharge,
                )
            }
            Spacer(modifier = Modifier.weight(0.07f))
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                RegularField(
                    stateHolder = unPackingChargeState,
                    wordType = false,
                    readOnly = true
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                OptionsField(
                    title = "LOADING CHARGE",
                    optionList = data.includingType,
                    selectedValue = selectedLoadingCharge,
                )
            }
            Spacer(modifier = Modifier.weight(0.07f))
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                RegularField(
                    stateHolder = loadingChargeState,
                    wordType = false,
                    readOnly = true
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                OptionsField(
                    title = "UNLOADING CHARGE",
                    optionList = data.includingType,
                    selectedValue = selectedUnloadingCharge,
                )
            }
            Spacer(modifier = Modifier.weight(0.07f))
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                RegularField(
                    stateHolder = unLoadingChargeState,
                    wordType = false,
                    readOnly = true
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                OptionsField(
                    title = "PACKING MATERIAL",
                    optionList = data.includingType,
                    selectedValue = selectedPackingMaterialCharge,
                )
            }
            Spacer(modifier = Modifier.weight(0.07f))
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                RegularField(
                    stateHolder = packingMaterialChargeState,
                    wordType = false,
                    readOnly = true
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                RegularField(
                    title = "STORAGE CHARGE",
                    stateHolder = storageChargeState,
                    wordType = false
                )
            }
            Spacer(modifier = Modifier.weight(0.07f))
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                RegularField(
                    title = "CAR/BIKE TPT",
                    stateHolder = vehicleTPTState,
                    wordType = false
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                RegularField(
                    title = "MISC. CHARGES",
                    stateHolder = miscChargeState,
                    wordType = false
                )
            }
            Spacer(modifier = Modifier.weight(0.07f))
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                RegularField(
                    title = "OTHER CHARGES",
                    stateHolder = otherChargeState,
                    wordType = false
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                RegularField(
                    title = "S.T. CHARGE",
                    stateHolder = stChargeState,
                    wordType = false
                )
            }
            Spacer(modifier = Modifier.weight(0.07f))
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                RegularField(
                    title = "GREEN TAX",
                    stateHolder = greenTaxState,
                    wordType = false
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Box(modifier = Modifier.weight(2f)) {
                OptionsField(
                    title = "GST IN/EX",
                    optionList = data.gstIn_ExList,
                    selectedValue = selectedGstIN_EX,
                )
            }

            Spacer(modifier = Modifier.weight(0.07f))
            Box(modifier = Modifier.weight(1f)) {
                OptionsField(
                    title = "GST %",
                    optionList = data.gstperc,
                    selectedValue = selectedGstPercentage,
                )
            }

            Spacer(modifier = Modifier.weight(0.07f))
            Box(modifier = Modifier.weight(2f)) {
                OptionsField(
                    title = "GST TYPE",
                    optionList = data.gstType,
                    selectedValue = selectedGstType,
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                OptionsField(
                    title = "REVERSE CHARGE",
                    optionList = data.yesNo,
                    selectedValue = selectedReverseCharge,
                )
            }
            Spacer(modifier = Modifier.weight(0.07f))
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                OptionsField(
                    title = "GST PAID BY",
                    optionList = data.gstPaidByList,
                    selectedValue = selectedGstPaidBy,
                )
            }
        }

        ExtendedField(
            title = "PAYMENT REMARK",
            stateHolder = paymentRemarkState,
            height = 80.dp
        )
        RegularField(
            stateHolder = discountState,
            title = "DISCOUNT"
        )
    }
}