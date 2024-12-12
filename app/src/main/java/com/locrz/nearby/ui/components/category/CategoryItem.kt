package com.locrz.nearby.ui.components.category

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.locrz.nearby.data.model.Category
import com.locrz.nearby.ui.theme.Gray300
import com.locrz.nearby.ui.theme.Gray400
import com.locrz.nearby.ui.theme.GreenBase
import com.locrz.nearby.ui.theme.Typography

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    category: Category,
    isSelected: Boolean,
    onCategoryClick: (isSelected: Boolean) -> Unit
) {
    FilterChip(
        modifier = modifier
            .heightIn(36.dp)
            .padding(2.dp),
        selected = isSelected,
        onClick = { onCategoryClick(!isSelected) },
        leadingIcon = {
            category.icon?.let { iconRes ->
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(iconRes),
                    contentDescription = category.name,
                    tint = if (isSelected) Color.White else Gray400
                )
            }
        },
        elevation = FilterChipDefaults.filterChipElevation(
            elevation = 8.dp
        ),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.White,
            selectedContainerColor = GreenBase
        ),
        border = FilterChipDefaults.filterChipBorder(
            enabled = false,
            selected = isSelected,
            disabledBorderColor = Gray300,
            borderWidth = 1.dp,
            selectedBorderWidth = 0.dp,
            selectedBorderColor = Color.Transparent
        ),
        label = {
            Text(
                text = category.name,
                style = Typography.bodyMedium,
                color = if (isSelected) Color.White else Gray400
            )
        }
    )
}

@Preview
@Composable
private fun CategoryItemPreview() {
    CategoryItem(
        modifier = Modifier,
        category = Category(
            name = "Alimentação",
            id = "1"
        ),
        onCategoryClick = {},
        isSelected = false
    )
}

@Preview
@Composable
private fun CategoryItemSelectedPreview() {
    CategoryItem(
        modifier = Modifier,
        category = Category(
            name = "Compras",
            id = "2"
        ),
        onCategoryClick = {},
        isSelected = true
    )
}