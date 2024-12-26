package com.locrz.nearby.ui.components.market

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.locrz.nearby.R
import com.locrz.nearby.data.model.Market
import com.locrz.nearby.ui.theme.Gray100
import com.locrz.nearby.ui.theme.Gray200
import com.locrz.nearby.ui.theme.Gray400
import com.locrz.nearby.ui.theme.Gray500
import com.locrz.nearby.ui.theme.Gray600
import com.locrz.nearby.ui.theme.RedBase
import com.locrz.nearby.ui.theme.Typography

@Composable
fun MarketCard(
    modifier: Modifier = Modifier,
    market: Market,
    onCardPress: (market: Market) -> Unit
) {
    val availableCouponsDescription =
        if (market.coupons == 1) "cupom disponível" else "cupons disponíveis";

    Card(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Gray100)
            .border(width = 1.dp, color = Gray200, shape = RoundedCornerShape(12.dp)),
        onClick = {
            onCardPress(market)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Gray100)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .clip(RoundedCornerShape(12.dp))
                    .height(IntrinsicSize.Min)
                    .aspectRatio(ratio = 1f, matchHeightConstraintsFirst = true),
//                painter = painterResource(R.drawable.img_burger),
                model = market.cover,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Column {
                Text(text = market.name, style = Typography.titleSmall, color = Gray600)
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = market.description,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = Typography.bodyMedium,
                    color = Gray500
                )
                Spacer(modifier = Modifier.size(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(R.drawable.ic_ticket),
                        contentDescription = "",
                        tint = if (market.coupons > 0) RedBase else Gray400,
                    )
                    Text(
                        text = "${market.coupons} ${availableCouponsDescription}",
                        style = Typography.bodyMedium,
                        color = Gray400
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun MarketCardPreview() {
    MarketCard(
        modifier = Modifier.fillMaxWidth(),
        market = Market(
            id = "1",
            name = "Loja do Zé",
            description = "Vendendo espetinhos até a madrugada, compre já e ganhe muitos cupons para a próxima compra do momento",
            coupons = 3,
            longitude = 0.0,
            latitude = 0.0,
            categoryId = "5",
            address = "",
            phone = "",
            cover = ""
        ),
        onCardPress = {},
    )
}


@Preview
@Composable
private fun MarketCardWithOneCouponPreview() {
    MarketCard(
        modifier = Modifier.fillMaxWidth(),
        market = Market(
            id = "1",
            name = "Loja do Zé",
            description = "Vendendo espetinhos até a madrugada, compre já e ganhe muitos cupons para a próxima compra do momento",
            coupons = 1,
            longitude = 0.0,
            latitude = 0.0,
            categoryId = "5",
            address = "",
            phone = "",
            cover = ""
        ),
        onCardPress = {},
    )
}

@Preview
@Composable
private fun MarketCardWithoutCouponsPreview() {
    MarketCard(
        modifier = Modifier.fillMaxWidth(),
        market = Market(
            id = "1",
            name = "Loja do Zé",
            description = "Vendendo espetinhos até a madrugada, compre já e ganhe muitos cupons para a próxima compra do momento",
            coupons = 0,
            longitude = 0.0,
            latitude = 0.0,
            categoryId = "5",
            address = "",
            phone = "",
            cover = ""
        ),
        onCardPress = {},
    )
}