package com.locrz.nearby.ui.components.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.locrz.nearby.R
import com.locrz.nearby.ui.theme.Gray500
import com.locrz.nearby.ui.theme.Typography

@Composable
fun WelcomeHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(R.drawable.img_logo_logo_icon),
            contentDescription = "Logo"
        )
        Column(
            modifier = Modifier.padding(top = 24.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Boas vindas ao Nearby!", style = Typography.headlineLarge)
            Text(
                text = "Tenha cupons de vantagem para usar em seus estabelecimentos favoritos.",
                style = Typography.bodyMedium,
                color = Gray500
            )
        }
    }
}

@Preview
@Composable
private fun WelcomeHeaderPreview() {
    WelcomeHeader(
        modifier = Modifier
    )
}