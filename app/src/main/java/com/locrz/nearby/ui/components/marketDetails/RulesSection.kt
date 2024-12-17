package com.locrz.nearby.ui.components.marketDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.locrz.nearby.data.model.Rule
import com.locrz.nearby.ui.theme.Gray500
import com.locrz.nearby.ui.theme.Typography

@Composable
fun RulesSection(modifier: Modifier = Modifier, couponRules: List<Rule>) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Regulamento", style = Typography.headlineSmall)
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = couponRules.joinToString(
                separator = "\n",
                transform = { "• ${it.description}" }),
            style = Typography.labelMedium,
            color = Gray500,
            lineHeight = 24.sp
        )
    }
}

@Preview
@Composable
private fun RulesSectionPreview() {
    RulesSection(
        modifier = Modifier.fillMaxWidth(),
//        couponRules = mockedStores[0].couponRules
        couponRules = emptyList()
    )
}