package com.locrz.nearby.ui.components.welcome

import androidx.annotation.DrawableRes
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
import com.locrz.nearby.ui.theme.Gray500
import com.locrz.nearby.ui.theme.RedBase
import com.locrz.nearby.ui.theme.Typography

@Composable
fun HowItWorkItem(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    title: String,
    description: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = "Map Icon",
            tint = RedBase,
            modifier = Modifier.size(24.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = title, style = Typography.labelLarge)
            Text(
                text = description,
                style = Typography.bodySmall,
                color = Gray500
            )
        }
    }

}

@Preview
@Composable
private fun HowItWorkItemPreview() {
    HowItWorkItem(
        modifier = Modifier.fillMaxWidth(),
        title = "Encontre estabelecimentos",
        description = "Veja locais perto de você que são parceiros Nearby",
        icon = R.drawable.ic_map_pin
    )
}