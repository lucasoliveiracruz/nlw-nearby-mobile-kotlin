package com.locrz.nearby.ui.screens.market_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.locrz.nearby.core.network.NearbyRemoteDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MarketDetailsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MarketDetailsUIState())
    val uiState: StateFlow<MarketDetailsUIState> = _uiState.asStateFlow()

    fun onEvent(event: MarketDetailsUIEvent) {
        when (event) {
            is MarketDetailsUIEvent.OnFetchCoupon -> generateCoupon(qrcode = event.qrcode)
            is MarketDetailsUIEvent.OnFetchRules -> fetchRules(marketId = event.marketId)
            MarketDetailsUIEvent.OnResetCoupon -> resetCoupon()
        }
    }

    private fun generateCoupon(qrcode: String) {
        viewModelScope.launch {
            _uiState.update { currentUiState ->
                NearbyRemoteDataSource.generateCoupon(marketId = qrcode).fold(
                    onSuccess = { coupon ->
                        currentUiState.copy(
                            coupon = coupon.coupon
                        )
                    },
                    onFailure = { _ ->
                        currentUiState.copy(
                            coupon = null
                        )
                    }
                )
            }
        }
    }

    private fun fetchRules(marketId: String) {
        viewModelScope.launch {
            _uiState.update { currentUiState ->
                NearbyRemoteDataSource.getMarketDetail(marketId).fold(
                    onSuccess = { details ->
                        currentUiState.copy(
                            rules = details.rules
                        )
                    },
                    onFailure = { _ ->
                        currentUiState.copy(
                            rules = null
                        )
                    }
                )
            }
        }
    }

    private fun resetCoupon() {
        viewModelScope.launch {
            _uiState.update { currentUiState ->
                currentUiState.copy(
                    coupon = null
                )
            }
        }
    }
}