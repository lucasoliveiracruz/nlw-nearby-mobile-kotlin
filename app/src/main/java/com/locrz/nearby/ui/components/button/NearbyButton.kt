package com.locrz.nearby.ui.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.locrz.nearby.R
import com.locrz.nearby.ui.theme.GreenBase
import com.locrz.nearby.ui.theme.Typography

@Composable
fun NearbyButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    onClick: () -> Unit,
    @DrawableRes iconRes: Int? = null
) {
    Button(
        modifier = modifier.heightIn(56.dp),
        shape = RoundedCornerShape(16.dp),
        onClick = onClick,
        contentPadding = if (iconRes !== null && text === null) PaddingValues(0.dp) else ButtonDefaults.ContentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenBase
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            iconRes?.let {
                Icon(
                    painter = painterResource(iconRes),
                    contentDescription = "Ícone",
                    modifier = Modifier.size(20.dp)
                )
            }
            text?.let {
                Text(text = text.uppercase(), style = Typography.labelLarge)
            }
        }
    }
}

@Preview
@Composable
private fun NearbyButtonWithTextPreview() {
    NearbyButton(
        modifier = Modifier.fillMaxWidth(),
        text = "Button text",
        onClick = {},
    )
}

@Preview
@Composable
private fun NearbyButtonIconPreview() {
    NearbyButton(
        modifier = Modifier, onClick = {}, iconRes = R.drawable.ic_scan
    )
}

@Preview
@Composable
private fun NearbyButtonTextIconPreview() {
    NearbyButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = {},
        iconRes = R.drawable.ic_scan,
        text = "Text with icon"
    )
}