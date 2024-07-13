package com.example.gangapackagesolution.Screens.BillScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.gangapackagesolution.Screens.BillScreen.ExpandedCards.VehicleInsuranceExpanded
import com.example.gangapackagesolution.ui.theme.GangaPackageSolutionTheme

@Preview(name="VehicleInsuranceExpanded")
@Composable
private fun PreviewApp() {
    GangaPackageSolutionTheme {
        Surface(color = Color.Black) {
            VehicleInsuranceExpanded()
        }
    }
}

//@Composable
//fun BillScreenForm(modifier: Modifier = Modifier) {
//
//}
//
//@Composable
//fun ActionCard(modifier: Modifier = Modifier) {
//    Card(modifier = modifier.fillMaxWidth(), elevation = CardElevation()) {
//
//    }
//}




















