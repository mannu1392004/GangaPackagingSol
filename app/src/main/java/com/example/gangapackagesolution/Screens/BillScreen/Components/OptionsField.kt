package com.example.gangapackagesolution.Screens.BillScreen.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun OptionsField(
    title: String? = null,
    optionList: List<String>,
    selectedValue: MutableState<String>,
    modifier: Modifier = Modifier.fillMaxWidth()
) {

    val openDialog = remember {
        mutableStateOf(false)
    }
    Column {
        Text(
            text = title ?: "",
            fontSize = 12.sp,
            color = Color.White
        )
        Surface(
            color = Color.White,
            modifier = modifier
                .clickable {
                    openDialog.value = true
                },
            shape = RoundedCornerShape(10.dp),
//            shadowElevation = 10.dp Removed elevation to make ui more consistent or add elevation to each component
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .padding(12.dp),
            ) {
                Text(
                    text = selectedValue.value,
                    fontSize = 12.sp
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = ""
                )
            }
        }
    }

    if (openDialog.value) {
        Dialog(onDismissRequest = { }) {
            Surface(shape = RoundedCornerShape(10.dp)) {
                LazyColumn(modifier = Modifier.padding(10.dp)) {
                    items(optionList) {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    selectedValue.value = it
                                    openDialog.value = false
                                },
                            color = if (it == selectedValue.value) Color.LightGray else Color.White
                        ) {
                            HorizontalDivider()
                            Text(
                                text = it,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}