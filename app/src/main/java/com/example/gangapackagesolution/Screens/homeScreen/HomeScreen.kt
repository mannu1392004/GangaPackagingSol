package com.example.gangapackagesolution.Screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gangapackagesolution.R
import com.example.gangapackagesolution.Screens.screenName.Screens
import com.example.gangapackagesolution.ui.theme.latolight
import com.example.gangapackagesolution.ui.theme.latosemibold
import kotlinx.coroutines.delay

@Preview(showSystemUi = true, showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val ScreenHeight = LocalConfiguration.current.screenHeightDp.dp

    Scaffold(modifier = Modifier,
        topBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xffF7F7F7)
            ) {
                Text(text = "")
            }
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors
                        = listOf(Color(0xff62248F), Color(0xff62248F))
                    )
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFF7F7F7),
                        shape = RoundedCornerShape(bottomEnd = 50.dp, bottomStart = 50.dp)
                    )
                    .clip(CircleShape)
                    .height(ScreenHeight / 5)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TopHEader()

                SubscriptionCard()



                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    SearchBox()


                    Spacer(modifier = Modifier.height(5.dp))

                    Surface(
                        modifier = Modifier.padding(20.dp),
                        color = Color(0xffF7F7F7),
                        shape = RoundedCornerShape(10.dp)
                    ) {


                        Column(
                            modifier = Modifier
                                .padding(14.dp)
                                .fillMaxWidth()
                                .padding(start = 5.dp, end = 5.dp, top = 20.dp, bottom = 20.dp)

                        ) {
                            Text(
                                text = "Quick Access",
                                fontFamily = latosemibold,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                MainContent(R.drawable.quotation, "Quotation", Modifier.clickable {
                                    navController.navigate(Screens.GetQuote.name)
                                })

                                MainContent(R.drawable.checklist, "Packing List", Modifier)

                                MainContent(R.drawable.box_truck, "L-R Bility", Modifier)
                            }

                            Spacer(modifier = Modifier.height(20.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                MainContent(R.drawable.bill, "Bill", Modifier)

                                MainContent(R.drawable.receipt, "Money Reciept", Modifier)

                                MainContent(R.drawable.help, "Help", Modifier)
                            }
                        }
                    }

                    HorizontalDivider(modifier = Modifier.padding(start = 20.dp, end = 20.dp))

                    // to navigate to another screen
                    NavigationSurface("Quotation", R.drawable.quotation) {
                        navController.navigate(Screens.QuoteList.name)
                    }

                    NavigationSurface("Packing List", R.drawable.checklist) {

                    }

                    NavigationSurface("L-R Bility", R.drawable.box_truck) {}

                    NavigationSurface("Bill", R.drawable.bill) {}

                    NavigationSurface("Money Reciept", R.drawable.receipt) {}


                    Spacer(modifier = Modifier.padding(10.dp))

                }


            }
        }
    }
}

@Composable
fun NavigationSurface(s: String, image: Int, onClick: () -> Unit) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(start = 20.dp, end = 20.dp, top = 20.dp),
        color = Color(0xffF7F7F7),
        shape = RoundedCornerShape(10.dp)
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = image), contentDescription = "",
                modifier = Modifier.size(40.dp)
            )
            Column {
                Text(
                    text = s,
                    fontFamily = latosemibold,
                    style = MaterialTheme.typography.titleLarge
                )


                Text(
                    text = "Tap to view $s List",
                    fontFamily = latolight,
                    style = MaterialTheme.typography.bodySmall
                )

            }

            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "")

        }

    }

}

@Composable
fun MainContent(quotation: Int, s: String, modifier: Modifier) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        color = Color.Transparent,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {


            Image(
                painter = painterResource(id = quotation), contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .padding(10.dp)
            )

            Text(
                text = s,
                fontFamily = latosemibold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(3.dp)
            )
        }
    }


}

@Composable
fun TopHEader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "",
            modifier = Modifier.size(30.dp)
        )

        Text(
            text = "Ganga Packager\n Solution", textAlign = TextAlign.Center,
            fontFamily = latosemibold,
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xff62248F),
            modifier = Modifier
        )
        Image(
            painter = painterResource(id = R.drawable.notification),
            contentDescription = "",
            modifier = Modifier
                .size(30.dp)
        )


    }

}

@Composable
fun SearchBox() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp),
        color = Color.White,
        shape = RoundedCornerShape(10.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "")
            Text(
                text = "Search here..",
                modifier = Modifier.padding(10.dp),
                fontFamily = latosemibold
            )
        }

    }
}


@Composable
fun SubscriptionCard() {
    val rate = listOf(
        "Rs. 149/Month",
        "Rs. 1299/Year"
    )
    val show = remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            if (show.intValue == rate.size) {
                show.intValue = 0
            }
            delay(2000)
            show.intValue += 1

        }
    }

    Card(
        elevation = CardDefaults.elevatedCardElevation(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .border(color = Color.Transparent, width = 2.dp, shape = RoundedCornerShape(10.dp)),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {
                    Text(
                        text = "Company Name",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xff62248F)
                    )

                    Text(
                        "The Company",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xff62248F)
                    )
                }

                Surface {
                    Text(
                        "Subscribe",
                        modifier = Modifier.padding(3.dp),
                        style = MaterialTheme.typography.bodySmall,
                    )
                }


            }

            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        "Current Plan",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xff62248F)
                    )
                    Text(
                        "Free",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xff62248F)
                    )
                }


                Text(
                    rate[show.intValue],
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xff62248F)
                )

            }
        }
    }

}

