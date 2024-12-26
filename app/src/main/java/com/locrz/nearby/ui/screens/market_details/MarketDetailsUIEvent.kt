package com.locrz.nearby.ui.screens.market_details

sealed class MarketDetailsUIEvent {
    data class OnFetchRules(val marketId: String): MarketDetailsUIEvent()
    data class OnFetchCoupon(val qrcode: String): MarketDetailsUIEvent()
    data object OnResetCoupon: MarketDetailsUIEvent()
}