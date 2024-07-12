package com.example.gangapackagesolution.Screens.quotationScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.example.gangapackagesolution.Screens.MainViewModel
import com.example.gangapackagesolution.Screens.loadingAndErrorScreen.ErrorScreen
import com.example.gangapackagesolution.Screens.loadingAndErrorScreen.LoadingScreen
import kotlinx.coroutines.delay

@Composable
fun QuotationMainScreen(MainViewModel :MainViewModel= MainViewModel()) {
    val showScreen = remember {
        mutableStateOf(true)
    }


    val quotationState = MainViewModel.quotation.collectAsState()


    LaunchedEffect(Unit) {


        MainViewModel.getQuotation()

        if (!quotationState.value.loading) {
            delay(1000)
            showScreen.value = false
        }
    }

    if (
        showScreen.value
    ) {

        LoadingScreen(color = Color(0xFF673AB7), indicatorColor = Color.White)
    } else {
if (quotationState.value.data!=null) {
    QuotationScreen(quotationState.value.data!!){

    }
}
        else{
            ErrorScreen(
                error ="haha",
            ){

            }
        }
    }

}