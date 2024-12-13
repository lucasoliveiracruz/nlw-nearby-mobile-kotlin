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
import androidx.compose.material3.HorizontalDivider
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
import coil3.compose.AsyncImage
import com.locrz.nearby.R
import com.locrz.nearby.data.model.Store
import com.locrz.nearby.data.model.mocks.mockedStores
import com.locrz.nearby.ui.components.button.NearbyButton
import com.locrz.nearby.ui.components.storeDetails.AvailableCoupons
import com.locrz.nearby.ui.components.storeDetails.InfoSection
import com.locrz.nearby.ui.components.storeDetails.RulesSection
import com.locrz.nearby.ui.theme.GreenBase
import com.locrz.nearby.ui.theme.Typography

@Composable
fun StoreDetailScreen(modifier: Modifier = Modifier, store: Store, goBack: () -> Unit) {

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            contentDescription = "Store image",
            contentScale = ContentScale.Crop,
//            model = store.imageUrl,
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
                // Store details
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
                        Text(text = store.name, style = Typography.headlineLarge)
                        Icon(
                            painter = painterResource(R.drawable.ic_shopping_bag),
                            contentDescription = "Store icon",
                            tint = GreenBase
                        )
                    }

                    Text(text = store.description, style = Typography.bodyMedium)

                    AvailableCoupons(
                        modifier = Modifier.fillMaxWidth(), coupons = store.coupons
                    )

                    InfoSection(
                        modifier = Modifier.fillMaxWidth(), store = store
                    )

//                    if (store.couponRules.isNotEmpty()) {
//                        HorizontalDivider(
//                            modifier = Modifier.fillMaxWidth()
//                        )
//                        RulesSection(
//                            modifier = Modifier.fillMaxWidth(), couponRules = store.couponRules
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
private fun StoreDetailScreenPreview() {
    StoreDetailScreen(
        modifier = Modifier,
        store = mockedStores[0],
        goBack = {}
    )
}