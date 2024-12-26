package com.locrz.nearby.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.locrz.nearby.data.model.Market
import com.locrz.nearby.ui.components.category.CategoryList
import com.locrz.nearby.ui.components.home.NearbyMap
import com.locrz.nearby.ui.components.market.MarketsList
import com.locrz.nearby.ui.theme.Gray100
import com.locrz.nearby.ui.theme.Gray200
import com.locrz.nearby.ui.theme.GreenBase
import com.locrz.nearby.ui.theme.GreenLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUIState,
    onEvent: (HomeUIEvent) -> Unit,
    openMarketDetails: (Market) -> Unit
) {
    val bottomSheetState = rememberBottomSheetScaffoldState()
    val screenHeight = LocalConfiguration.current.screenHeightDp

    LaunchedEffect(key1 = true) {
        onEvent(HomeUIEvent.OnFetchCategories)
    }

    BottomSheetScaffold(
        scaffoldState = bottomSheetState,
        sheetContainerColor = Gray100,
        sheetPeekHeight = screenHeight.dp * 0.5f,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Gray200)
            ) {
                NearbyMap(uiState = uiState)

                if (!uiState.categories.isNullOrEmpty()) {
                    CategoryList(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        categories = uiState.categories,
                        onCategoryChanged = { selectedCategory ->
                            onEvent(HomeUIEvent.OnFetchMarkets(selectedCategory.id))
                        }
                    )
                }

            }
        },
        sheetContent = {
            if (!uiState.markets.isNullOrEmpty()) {
                MarketsList(
                    modifier = modifier,
                    markets = uiState.markets,
                    onMarketChanged = openMarketDetails
                )
            } else {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(64.dp)
                        .align(Alignment.CenterHorizontally),
                    color = GreenBase,
                    trackColor = GreenLight,
                )
            }
        }
    )
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        modifier = Modifier,
        openMarketDetails = {},
        onEvent = {},
        uiState = HomeUIState()
    )
}