package com.locrz.nearby.ui.components.marketDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.locrz.nearby.R
import com.locrz.nearby.ui.theme.Gray400
import com.locrz.nearby.ui.theme.Gray600
import com.locrz.nearby.ui.theme.RedBase
import com.locrz.nearby.ui.theme.RedLight
import com.locrz.nearby.ui.theme.Typography

@Composable
fun AvailableCoupons(modifier: Modifier = Modifier, coupons: Int) {
    val availableCouponsDescription =
        if (coupons == 1) "cupom disponível" else "cupons disponíveis"

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(RedLight)
            .heightIn(44.dp)
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(R.drawable.ic_ticket),
            contentDescription = "",
            tint = if (coupons > 0) RedBase else Gray400,
        )
        Text(
            text = "$coupons $availableCouponsDescription",
            style = Typography.labelMedium,
            color = Gray600
        )
    }
}

@Preview
@Composable
private fun AvailableCouponsPreview() {
    AvailableCoupons(
        modifier = Modifier.fillMaxWidth(),
        coupons = 5,
    )
}