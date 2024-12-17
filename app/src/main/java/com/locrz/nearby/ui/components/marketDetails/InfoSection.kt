package com.locrz.nearby.ui.components.marketDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.locrz.nearby.R
import com.locrz.nearby.data.model.Market
import com.locrz.nearby.data.model.mocks.mockedMarkets
import com.locrz.nearby.ui.theme.Gray400
import com.locrz.nearby.ui.theme.Typography

@Composable
fun InfoSection(modifier: Modifier = Modifier, market: Market) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Informações", style = Typography.headlineSmall)

        Column (
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row (
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(R.drawable.ic_map_pin),
                    contentDescription = "Address icon",
                    tint = Gray400
                )
                Text(text = market.address, style = Typography.bodyMedium, color = Gray400)
            }
            Row (
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(R.drawable.ic_phone),
                    contentDescription = "Address icon",
                    tint = Gray400
                )
                Text(text = market.phone, style = Typography.bodyMedium, color = Gray400)
            }
        }
    }
}

@Preview
@Composable
private fun InfoSectionPreview() {
    InfoSection(
        modifier = Modifier.fillMaxWidth(),
        market = mockedMarkets[0]
    )
}