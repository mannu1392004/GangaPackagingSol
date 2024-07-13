package com.example.gangapackagesolution.Screens.quotationScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.gangapackagesolution.Screens.MainViewModel
import com.example.gangapackagesolution.Screens.loadingAndErrorScreen.ErrorScreen
import com.example.gangapackagesolution.Screens.loadingAndErrorScreen.LoadingScreen
import com.example.gangapackagesolution.Screens.screenName.Screens
import kotlinx.coroutines.delay

@Composable
fun QuotationMainScreen(MainViewModel: MainViewModel, navController: NavController) {

    val showScreen = remember {
        mutableStateOf(true)
    }


    val quotationState = MainViewModel.quotation.collectAsState()

    val quotationSaveState = MainViewModel.quotaionSaveState.collectAsState()




    LaunchedEffect(Unit) {


        MainViewModel.getQuotation()

        if (!quotationState.value.loading) {
            delay(500)
            showScreen.value = false
        }
    }

    if (
        showScreen.value
    ) {
        LoadingScreen(color = Color(0xFF673AB7), indicatorColor = Color.White)
    } else {
        if (quotationState.value.data != null) {
            QuotationScreen(quotationState.value.data!!) {
                showScreen.value = true
                MainViewModel.saveNewQuotation(it) {
                    navController.navigate(Screens.QuoteList.name){
                        popUpTo(Screens.Home.name)
                        launchSingleTop = true
                    }
                }



            }
        }
    }
    if (quotationState.value.e != null||quotationSaveState.value.e!=null) {
        ErrorScreen(quotationState.value.e!!.message!!) {
            MainViewModel.resetError()
            navController.navigate(Screens.Home.name)
        }
    }


}