package com.locrz.nearby.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.maps.android.compose.GoogleMap
import com.locrz.nearby.data.model.Market
import com.locrz.nearby.data.model.mocks.mockedCategories
import com.locrz.nearby.data.model.mocks.mockedMarkets
import com.locrz.nearby.ui.components.category.CategoryList
import com.locrz.nearby.ui.components.market.MarketsList
import com.locrz.nearby.ui.theme.Gray100
import com.locrz.nearby.ui.theme.Gray200
import com.locrz.nearby.ui.theme.GreenLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, openMarketDetails: (Market) -> Unit) {
    val bottomSheetState = rememberBottomSheetScaffoldState()
    var isBottomSheetVisible by remember { mutableStateOf(true) }

    val screenHeight = LocalConfiguration.current.screenHeightDp

    if (!isBottomSheetVisible) {
        // empty state
        Box(
            modifier = Modifier
                .background(GreenLight)
                .fillMaxSize()
        )
    } else
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
                    GoogleMap(

                    )
                    CategoryList(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        categories = mockedCategories,
                        onCategoryChanged = {}
                    )
                }
            },
            sheetContent = {
                MarketsList(
                    modifier = modifier,
                    markets = mockedMarkets,
                    onMarketChanged = openMarketDetails
                )
            }
        )
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        modifier = Modifier,
        openMarketDetails = {}
    )
}