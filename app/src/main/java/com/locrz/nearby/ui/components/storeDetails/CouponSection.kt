package com.locrz.nearby.ui.components.storeDetails

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
import com.locrz.nearby.ui.theme.Gray400
import com.locrz.nearby.ui.theme.GreenLight
import com.locrz.nearby.ui.theme.Typography

@Composable
fun CouponSection(modifier: Modifier = Modifier, coupons: List<String>) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Cupons usados", style = Typography.headlineSmall)

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            coupons.forEach { coupon ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(R.drawable.ic_ticket),
                        contentDescription = "Coupon icon",
                        tint = GreenLight
                    )
                    Text(text = coupon, style = Typography.bodyMedium, color = Gray400)
                }
            }

        }
    }
}

@Preview
@Composable
private fun CouponSectionPreview() {
    CouponSection(
        modifier = Modifier.fillMaxWidth(),
        coupons = listOf(
            "Cupom 1",
            "Cupom 2",
            "Cupom 3"
        )
    )
}