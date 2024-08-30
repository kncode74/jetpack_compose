package com.example.jetpack.models

data class TodoResponse(
    val imageResource: String?,
    val title: String?,
    val discount: Int?,
    var isSold: Boolean?,
)