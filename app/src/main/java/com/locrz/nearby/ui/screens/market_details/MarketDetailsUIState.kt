package com.locrz.nearby.ui.screens.market_details;

import com.locrz.nearby.data.model.Rule

data class MarketDetailsUIState (
    val rules: List<Rule>? = null,
    val coupon: String? = null,
)