package com.locrz.nearby.ui.components.store

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.locrz.nearby.data.model.Store
import com.locrz.nearby.data.model.mocks.mockedStores
import com.locrz.nearby.ui.theme.Typography

@Composable
fun StoresList(
    modifier: Modifier = Modifier,
    stores: List<Store>,
    onStoreChanged: (store: Store) -> Unit
) {

    LazyColumn(
        modifier = modifier
            .background(Color.White)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(text = "Explore locais perto de você", style = Typography.bodyLarge)
        }

        items(items = stores, key = { s -> s.id }) { store ->
            CardStore(
                store = store,
                onCardPress = onStoreChanged
            )
        }
    }
}

@Preview
@Composable
private fun StoresListPreview() {
    StoresList(
        modifier = Modifier,
        stores = mockedStores,
        onStoreChanged = {}
    )
}