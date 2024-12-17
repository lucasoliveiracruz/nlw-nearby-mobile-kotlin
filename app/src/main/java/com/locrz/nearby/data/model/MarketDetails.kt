package com.locrz.nearby.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Rule(
    val id: String,
    val description: String,
    val marketId: String,
)

data class MarketDetails(
    val id: String,
    val name: String,
    val description: String,
    val coupons: Int = 0,
    val cover: String?,
    val address: String,
    val phone: String,
    val latitude: Double,
    val longitude: Double,
    val categoryId: String,
    val rules: List<Rule> = emptyList()
)
