package com.locrz.nearby.ui.screens.home

sealed class HomeUIEvent {
    data object OnFetchCategories : HomeUIEvent()
    data class OnFetchMarkets(val categoryId: String) : HomeUIEvent()
}