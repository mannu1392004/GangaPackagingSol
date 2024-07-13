package com.example.gangapackagesolution.Screens.BillScreen

import android.icu.util.Calendar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gangapackagesolution.Screens.BillScreen.Components.DateSelector
import com.example.gangapackagesolution.Screens.BillScreen.Components.ExtendedField
import com.example.gangapackagesolution.Screens.BillScreen.Components.OptionsField
import com.example.gangapackagesolution.Screens.BillScreen.Components.RegularField
import com.example.gangapackagesolution.data.Data
import com.example.gangapackagesolution.ui.theme.GangaPackageSolutionTheme

@Preview(name="VehicleInsuranceExpanded")
@Composable
private fun PreviewApp() {
    GangaPackageSolutionTheme {
        Surface(color = Color.Black) {
            ShowVehicleInsuranceDetails()
        }
    }
}

// TO BE IMPLEMENTED

// TODO: 1 IMPLEMENT Consignor Details
// TODO: 2 Remove duplicate similar expanded menu for insurance and vehicle insurance
// TODO: 3 REMOVE DUPLICATE SIMILAR expanded menu for billing and consignee details





















