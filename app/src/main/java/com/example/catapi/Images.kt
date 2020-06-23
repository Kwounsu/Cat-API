package com.example.catapi

data class Images (
    val breeds : List<String>,
    val id : String,
    val url : String,
    val width : Int,
    val height : Int
)