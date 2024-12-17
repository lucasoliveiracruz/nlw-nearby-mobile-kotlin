package com.locrz.nearby.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.locrz.nearby.R
import com.locrz.nearby.data.model.Market
import com.locrz.nearby.data.model.mocks.mockedMarkets
import com.locrz.nearby.ui.components.button.NearbyButton
import com.locrz.nearby.ui.components.marketDetails.AvailableCoupons
import com.locrz.nearby.ui.components.marketDetails.InfoSection
import com.locrz.nearby.ui.theme.GreenBase
import com.locrz.nearby.ui.theme.Typography

@Composable
fun MarketDetailScreen(modifier: Modifier = Modifier, market: Market, goBack: () -> Unit) {

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            contentDescription = "Market image",
            contentScale = ContentScale.Crop,
//            model = market.imageUrl,
            painter = painterResource(R.drawable.img_burger)
        )

        NearbyButton(
            modifier = Modifier.padding(start = 32.dp, top = 32.dp),
            iconRes = R.drawable.ic_arrow_left,
            onClick = goBack,
        )

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
                .align(Alignment.BottomCenter)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
            ) {
                // Market details
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = market.name, style = Typography.headlineLarge)
                        Icon(
                            painter = painterResource(R.drawable.ic_shopping_bag),
                            contentDescription = "Market icon",
                            tint = GreenBase
                        )
                    }

                    Text(text = market.description, style = Typography.bodyMedium)

                    AvailableCoupons(
                        modifier = Modifier.fillMaxWidth(), coupons = market.coupons
                    )

                    InfoSection(
                        modifier = Modifier.fillMaxWidth(), market = market
                    )

//                    if (market.couponRules.isNotEmpty()) {
//                        HorizontalDivider(
//                            modifier = Modifier.fillMaxWidth()
//                        )
//                        RulesSection(
//                            modifier = Modifier.fillMaxWidth(), couponRules = market.couponRules
//                        )
//                    }
                }

                // Footer With Buttons
                Row(
                    modifier = Modifier.padding(top = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    NearbyButton(modifier = Modifier, iconRes = R.drawable.ic_map_pin, onClick = {})
                    NearbyButton(modifier = Modifier.fillMaxWidth(),
                        iconRes = R.drawable.ic_scan,
                        text = "Ler QR Code",
                        onClick = {})
                }
            }


        }
    }
}

@Preview
@Composable
private fun MarketDetailScreenPreview() {
    MarketDetailScreen(
        modifier = Modifier,
        market = mockedMarkets[0],
        goBack = {}
    )
}