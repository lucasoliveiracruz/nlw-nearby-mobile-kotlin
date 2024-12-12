package com.locrz.nearby.data.model

data class Rule(
    val id: String,
    val description: String,
    val storeId: String,
)

data class Store(
    val id: String,
    val categoryId: String,
    val name: String,
    val description: String,
    val coupons: Int = 0,
    val imageUrl: String?,
    val fullAddress: String,
    val phone: String,
    val latitude: Double,
    val longitude: Double,
    val couponRules: List<Rule> = emptyList()
)
