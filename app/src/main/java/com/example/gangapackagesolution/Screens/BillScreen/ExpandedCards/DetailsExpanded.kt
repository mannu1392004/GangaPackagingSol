package com.example.gangapackagesolution.Screens.BillScreen.ExpandedCards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gangapackagesolution.Screens.BillScreen.Components.DateSelector
import com.example.gangapackagesolution.Screens.BillScreen.Components.OptionsField
import com.example.gangapackagesolution.Screens.BillScreen.Components.RegularField
import com.example.gangapackagesolution.Screens.BillScreen.utils.getCurrentDate
import com.example.gangapackagesolution.data.Data

@Composable
fun DetailsExpanded(modifier: Modifier = Modifier) {
    val data = Data()

    // implement states
    val billNumber = remember {
        mutableStateOf("0001")
    }
    val companyName = remember {
        mutableStateOf("")
    }
    val lrNumber = remember {
        mutableStateOf("")
    }
    val movingPath = remember {
        mutableStateOf("")
    }
    val moveFrom = remember {
        mutableStateOf("")
    }
    val moveTo = remember {
        mutableStateOf("")
    }
    val vehicleNumber = remember {
        mutableStateOf("")
    }
    val invoiceDate = remember {
        mutableStateOf(getCurrentDate())
    }
    val deliveryDate = remember {
        mutableStateOf(getCurrentDate())
    }
    val selectedPathOption = remember {
        mutableStateOf("")
    }
    val shipmentType = remember {
        mutableStateOf("Household Goods")
    }

    // Card Implementation
    Card (colors = CardDefaults.cardColors(containerColor = Color(0xFF673AB7))){
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier
                .padding(10.dp)
                .fillMaxSize()
        ) {

            RegularField(
                stateHolder = billNumber,
                title = "INVOICE/BILL NUMBER",
                wordType = false
            )

            RegularField(
                stateHolder = companyName,
                title = "COMPANY NAME OF PARTY"
            )

            RegularField(
                stateHolder = lrNumber,
                title = "LR NUMBER",
                wordType = false
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                DateSelector(
                    title = "INVOICE DATE",
                    selectedDate = invoiceDate,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )

                Spacer(modifier = Modifier.weight(0.1f))

                DateSelector(
                    title = "DELIVERY DATE",
                    selectedDate = deliveryDate,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )

            }

            OptionsField(
                title = "MOVING PATH",
                optionList = data.movingPathList,
                selectedValue = selectedPathOption
            )

            RegularField(
                stateHolder = shipmentType,
                title = "TYPE OF SHIPMENT"
            )

            RegularField(
                stateHolder = movingPath,
                title = "MOVING PATH REMARK"
            )

            RegularField(
                stateHolder = moveFrom,
                title = "MOVE FROM"
            )

            RegularField(
                stateHolder = moveTo,
                title = "MOVE TO"
            )

            RegularField(
                stateHolder = vehicleNumber,
                title = "VEHICLE NUMBER",
                wordType = false
            )

        }
    }

}