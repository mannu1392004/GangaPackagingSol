package com.example.gangapackagesolution.Screens.BillScreen.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegularField(
    stateHolder: MutableState<String>,
    readOnly: Boolean = false,
    title: String? = null,
    modifier: Modifier = Modifier.fillMaxWidth(),
    wordType: Boolean = true
) {

    Column() {
        Text(
            text = title ?: "",
            fontSize = 12.sp,
            color = Color.White
        )
        Surface(
            modifier = modifier, color = Color.White,
            shape = RoundedCornerShape(10.dp),
            ) {
            if (wordType) {
                BasicTextField(
                    value = stateHolder.value,
                    onValueChange = { stateHolder.value = it }, readOnly = readOnly,
                    textStyle = TextStyle(fontSize = 18.sp),
                    modifier = modifier.padding(10.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        KeyboardCapitalization.Words
                    )
                )

            } else {
                BasicTextField(
                    value = stateHolder.value, onValueChange = {
                        if (!it.contains(",") && it.count { char ->
                                char == '.'
                            } <= 1 && it != ".") {
                            stateHolder.value = it
                        }

                    },
                    modifier = modifier.padding(10.dp), textStyle = TextStyle(fontSize = 18.sp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                )
            }
        }
    }
}