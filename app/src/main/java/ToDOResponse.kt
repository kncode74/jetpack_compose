package com.example.jetpack

    data class ItemResponse(
    val imageResource: String,
    val title: String,
    val description: String,
    val discount: Int,
    var isSold: Boolean
)