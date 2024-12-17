package com.locrz.nearby.core.network

import com.locrz.nearby.data.model.Category
import com.locrz.nearby.data.model.Coupon
import com.locrz.nearby.data.model.Market
import com.locrz.nearby.data.model.MarketDetails
import com.locrz.nearby.core.network.KtorHttpClient.httpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch

object NearbyRemoteDataSource {

    private const val LOCALHOST_EMULATOR_BASE_URL = "http://10.0.2.2:3333"
    private const val BASE_URL = LOCALHOST_EMULATOR_BASE_URL

    suspend fun getCategories(): Result<List<Category>> = try {
        val categories = httpClient.get("$BASE_URL/categories").body<List<Category>>()
        Result.success(categories)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getMarketsByCategoryId(categoryId: String): Result<List<Market>> = try {
        val markets = httpClient.get("$BASE_URL/markets/category/$categoryId").body<List<Market>>()
        Result.success(markets)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getMarketDetail(marketId: String): Result<MarketDetails> = try {
        val market = httpClient.get("$BASE_URL/markets/$marketId").body<MarketDetails>()
        Result.success(market)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun generateCoupon(marketId: String): Result<Coupon> = try {
        val result = httpClient.patch("$BASE_URL/coupons/$marketId").body<Coupon>()
        Result.success(result)
    } catch (e: Exception) {
        Result.failure(e)
    }
}