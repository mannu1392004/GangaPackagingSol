package com.example.gangapackagesolution.Screens.nav

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gangapackagesolution.Screens.Login
import com.example.gangapackagesolution.Screens.MainViewModel
import com.example.gangapackagesolution.Screens.homeScreen.HomeScreen
import com.example.gangapackagesolution.Screens.loginViewmodel
import com.example.gangapackagesolution.Screens.quotationScreen.QuotationMainScreen
import com.example.gangapackagesolution.Screens.quotationScreen.QuotationScreen
import com.example.gangapackagesolution.Screens.quotationScreen.quotationShow.QuotationListShow
import com.example.gangapackagesolution.Screens.screenName.Screens
import com.example.gangapackagesolution.repository.TokenManagement

@Composable
fun MainNav(context: Context) {
    val TokenManagement = TokenManagement(context)
    val navController = rememberNavController()
    val mainViewModel = MainViewModel()

    NavHost(
        navController = navController, startDestination =
        Screens.Home.name
        /*
         if (TokenManagement.getToken().isNullOrBlank()) {
             Screens.Login.name
         } else {
             Screens.Home.name
         }
         */

    ) {

        composable(route = Screens.Login.name) {
            val loginViewmodel = loginViewmodel(context)
            Login(loginViewmodel, navController)
        }


        // homeScreen
        composable(route = Screens.Home.name) {
            HomeScreen(navController)
        }

        // ListOfQuotations
        composable(route = Screens.QuoteList.name) {
            QuotationListShow(viewModel = mainViewModel, navController)
        }

//QuoteEditForm
        composable(
            route = Screens.QuoteForm.name
        ) {

            mainViewModel.quotationForEdit?.let { it1 ->
                QuotationScreen(
                    data =
                    it1,
                ) {
                    mainViewModel.saveEditedQuotation(quotation = it)
                    navController.popBackStack()
                }
            }

        }

        // getQuotationScreen

        composable(
            route = Screens.GetQuote.name
        ) {
            QuotationMainScreen(
                navController = navController,
                MainViewModel = mainViewModel
            )
        }


    }


}