package com.mehedi.simpleepoxy

data class Shop(
    val id: Int,
    val name: String,
    val description: String
)

data class Banner(val id: Int, val imageUrl: String)
data class Category(val id: Int, val name: String, val imageUrl: String)
data class Product(val id: Int, val name: String, val price: String, val imageUrl: String)
data class SectionHeader(
    val title: String,
    val showViewAll: Boolean = false,  // If true, show the "View All" button
    val onViewAllClick: (() -> Unit)? = null  // Optional click listener for "View All"
)
