package com.locrz.nearby.ui.components.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.locrz.nearby.R
import com.locrz.nearby.ui.theme.Gray500
import com.locrz.nearby.ui.theme.Typography

@Composable
fun HowItWorkSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Veja como funciona:", style = Typography.bodyMedium, color = Gray500)

        HowItWorkItem(
            title = "Encontre estabelecimentos",
            description = "Veja locais perto de você que são parceiros Nearby",
            icon = R.drawable.ic_map_pin
        )
        HowItWorkItem(
            title = "Ative o cupom com QR Code",
            description = "Escaneie o código no estabelecimento para usar o benefício",
            icon = R.drawable.ic_qrcode
        )
        HowItWorkItem(
            title = "Garanta vantagens perto de você",
            description = "Ative cupons onde estiver, em diferentes tipos de estabelecimento ",
            icon = R.drawable.ic_ticket
        )
    }
}

@Preview
@Composable
private fun HowItWorkSectionPreview() {
    HowItWorkSection(
        modifier = Modifier.fillMaxWidth()
    )
}