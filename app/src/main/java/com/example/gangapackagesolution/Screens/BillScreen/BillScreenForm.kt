@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.gangapackagesolution.Screens.BillScreen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gangapackagesolution.Screens.BillScreen.ExpandedCards.BillingExpanded
import com.example.gangapackagesolution.Screens.BillScreen.ExpandedCards.ConsigneeExpanded
import com.example.gangapackagesolution.Screens.BillScreen.ExpandedCards.DetailsExpanded
import com.example.gangapackagesolution.Screens.BillScreen.ExpandedCards.InsuranceExpanded
import com.example.gangapackagesolution.Screens.BillScreen.ExpandedCards.PackageExpanded
import com.example.gangapackagesolution.Screens.BillScreen.ExpandedCards.PaymentExpanded
import com.example.gangapackagesolution.Screens.BillScreen.ExpandedCards.VehicleInsuranceExpanded
import com.example.gangapackagesolution.ui.theme.GangaPackageSolutionTheme

@Preview(name = "VehicleInsuranceExpanded")
@Composable
private fun PreviewApp() {
    GangaPackageSolutionTheme {
        BillScreenApp()
    }
}

data class CardItem(
    val title: String,
    val content: @Composable () -> Unit
)

val cardItems = listOf(
    CardItem(
        "Details",
        { DetailsExpanded() }),
    CardItem(
        "Billing Details",
        { BillingExpanded() }),
    CardItem(
        "Consignee Details",
        { ConsigneeExpanded() }),
    CardItem(
        "Package Details",
        { PackageExpanded() }),
    CardItem(
        "Payment Details",
        { PaymentExpanded() }),
    CardItem(
        "Insurance Details",
        { InsuranceExpanded() }),
    CardItem(
        "Vehicle Insurance Details",
        { VehicleInsuranceExpanded() })
)

@Composable
fun BillScreenApp(modifier: Modifier = Modifier) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF673AB7),
                    scrolledContainerColor = Color(0xFF673AB7)
                ),
                navigationIcon = {
                    IconButton(onClick = { /*add navigation logic*/ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            tint = Color.White,
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text(
                        "Billing Form",
                        color = Color.White
                    )
                }
            )
        }
    ) { contentPadding ->
        // I should have created a separate data class and used forEach lambda here,
        // but it's not worth the effort, I still did it anyways

        Surface(color = Color.White) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .padding(contentPadding)
                    .padding(
                        horizontal = 20.dp,
                        vertical = 30.dp
                    )
                    .fillMaxSize()
            ) {
                items(cardItems) { card ->
                    ActionCard(
                        title = card.title,
                        expandCardCompose = card.content
                    )
                }
                item {
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = Color.DarkGray,
                        modifier = Modifier
                            .padding(vertical = 20.dp)
                    )
                }

                item {
                    Button(colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF673AB7)),
                        onClick = { /*Add your viewmodel logic*/ }) {
                        Row(verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Text("SAVE BILL", fontSize = 16.sp, color = Color.White)
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ActionCard(
    title: String,
    expandCardCompose: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    var expandState by remember {
        mutableStateOf(false) // make sure to set it to false default, I enabled true only for testing :)
    }
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF673AB7)),
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearEasing
                )
            )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(7.dp),
            modifier = modifier
                .padding(
                    start = 15.dp,
                    end = 15.dp,
                    top = 25.dp,
                    bottom = 25.dp
                )
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.clickable { expandState = !expandState }) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = if (expandState) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowRight,
                    tint = Color.White,
                    contentDescription = null
                )
            }
            if (expandState) expandCardCompose()
        }
    }
}




















