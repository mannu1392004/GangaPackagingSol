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
import com.example.gangapackagesolution.Screens.BillScreen.Components.OptionsField
import com.example.gangapackagesolution.Screens.BillScreen.Components.RegularField
import com.example.gangapackagesolution.data.Data

@Composable
fun VehicleInsuranceExpanded(modifier: Modifier = Modifier) {
    val data = Data()
    val declarationState = remember {
        mutableStateOf("")
    }
    val selectedInsuranceType = remember {
        mutableStateOf(data.insuranceType[2])
    }
    val selectedInsuranceCharge = remember {
        mutableStateOf(data.insuranceCharge[16])
    }
    val selectedGstPercentage = remember {
        mutableStateOf(data.gstperc[1])
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        OptionsField(
            title = "INSURANCE TYPE",
            optionList = data.insuranceType,
            selectedValue = selectedInsuranceType,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Box(modifier = Modifier.weight(3f)) {
                OptionsField(
                    title = "INSURANCE CHARGE(%)",
                    optionList = data.insuranceCharge,
                    selectedValue = selectedInsuranceCharge,
                )
            }
            Spacer(modifier = Modifier.weight(0.1f))
            Box(modifier = Modifier.weight(1f)) {
                OptionsField(
                    title = "GST %",
                    optionList = data.gstperc,
                    selectedValue = selectedGstPercentage,
                )
            }
        }
        RegularField(
            title = "DECLARATION VALUE OF VEHICLE",
            stateHolder = declarationState,
            wordType = false
        )
    }
}