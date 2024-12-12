package com.locrz.nearby.ui.components.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.locrz.nearby.data.model.Category
import com.locrz.nearby.data.model.mocks.mockedCategories

@Composable
fun CategoryList(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    onCategoryChanged: (category: Category) -> Unit
) {
    // const [selectedCategoryId, setSelectedCategoryId] = useState(categories[0]?.id ?? "")
    var selectedCategoryId by remember { mutableStateOf(categories.firstOrNull()?.id.orEmpty()) }

    LaunchedEffect(key1 = selectedCategoryId) {
        val selectedCategory = categories.find { it.id === selectedCategoryId }
        if (selectedCategory !== null) onCategoryChanged(selectedCategory);
    }

    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items = categories, key = { c -> c.id }) { category ->
            CategoryItem(
                modifier = modifier,
                category = category,
                isSelected = category.id === selectedCategoryId,
                onCategoryClick = { isSelected ->
                    // setSelectedCategoryId(category.id)
                    if (isSelected) selectedCategoryId = category.id
                })
        }
    }
}

@Preview
@Composable
private fun CategoryListPreview() {
    CategoryList(
        modifier = Modifier.fillMaxWidth(),
        categories = mockedCategories,
        onCategoryChanged = {}
    )
}