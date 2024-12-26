package com.locrz.nearby.ui.screens.home

import com.google.android.gms.maps.model.LatLng
import com.locrz.nearby.data.model.Category
import com.locrz.nearby.data.model.Market

data class HomeUIState(
    val categories: List<Category>? = null,
    val markets: List<Market>? = null,
    val marketLocations: List<LatLng>? = null
)
