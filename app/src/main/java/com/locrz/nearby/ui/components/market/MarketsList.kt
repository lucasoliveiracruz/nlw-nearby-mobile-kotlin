package com.locrz.nearby.ui.components.market

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.locrz.nearby.data.model.Market
import com.locrz.nearby.data.model.mocks.mockedMarkets
import com.locrz.nearby.ui.theme.Typography

@Composable
fun MarketsList(
    modifier: Modifier = Modifier,
    markets: List<Market>,
    onMarketChanged: (market: Market) -> Unit
) {

    LazyColumn(
        modifier = modifier
            .background(Color.White)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(text = "Explore locais perto de você", style = Typography.bodyLarge)
        }

        items(items = markets, key = { s -> s.id }) { market ->
            MarketCard(
                market = market,
                onCardPress = onMarketChanged
            )
        }
    }
}

@Preview
@Composable
private fun MarketsListPreview() {
    MarketsList(
        modifier = Modifier,
        markets = mockedMarkets,
        onMarketChanged = {}
    )
}