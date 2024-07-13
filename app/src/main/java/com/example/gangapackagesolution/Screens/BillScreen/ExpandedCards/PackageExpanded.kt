package com.example.gangapackagesolution.Screens.BillScreen.ExpandedCards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gangapackagesolution.Screens.BillScreen.Components.ExtendedField
import com.example.gangapackagesolution.Screens.BillScreen.Components.OptionsField
import com.example.gangapackagesolution.Screens.BillScreen.Components.RegularField
import com.example.gangapackagesolution.data.Data

@Composable
fun PackageExpanded(modifier: Modifier = Modifier) {
    val data = Data()
    val packageState = remember {
        mutableStateOf("")
    }
    val descriptionState = remember {
        mutableStateOf("")
    }
    val weightState = remember {
        mutableStateOf("")
    }
    val selectedWeightState = remember {
        mutableStateOf("KG")
    }
    val remarkState = remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        RegularField(
            stateHolder = packageState,
            title = "PACKAGE"
        )
        RegularField(
            stateHolder = descriptionState,
            title = "DESCRIPTION",
            wordType = false
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
        )
        {
            Box(modifier = Modifier.weight(4f)) {
                RegularField(
                    stateHolder = weightState,
                    title = "TOTAL WEIGHT",
                    wordType = false,
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                OptionsField(
                    optionList = data.weightUnitList,
                    selectedValue = selectedWeightState
                )
            }
        }

        ExtendedField(
            title = "REMARK",
            stateHolder = remarkState,
            height = 120.dp
        )

    }
//    Surface(color = Color(0xFF673AB7)) {
////        Column(
////            verticalArrangement = Arrangement.spacedBy(10.dp),
////            modifier = modifier
////                .padding(10.dp)
////                .fillMaxSize()
////        ) {
////            RegularField(
////                stateHolder = packageState,
////                title = "PACKAGE"
////            )
////            RegularField(
////                stateHolder = descriptionState,
////                title = "DESCRIPTION",
////                wordType = false
////            )
////
////            Row(
////                verticalAlignment = Alignment.CenterVertically,
////                modifier = Modifier
////                    .fillMaxWidth()
////                    .height(70.dp),
////            )
////            {
////                Box(modifier = Modifier.weight(4f)) {
////                    RegularField(
////                        stateHolder = weightState,
////                        title = "TOTAL WEIGHT",
////                        wordType = false,
////                    )
////                }
////                Box(modifier = Modifier.weight(1f)) {
////                    OptionsField(
////                        optionList = data.weightUnitList,
////                        selectedValue = selectedWeightState
////                    )
////                }
////            }
////
////            ExtendedField(
////                title = "REMARK",
////                stateHolder = remarkState,
////                height = 120.dp
////            )
////
////        }
//    }
}