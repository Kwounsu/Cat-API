package com.example.catapi.model

data class Images (
    val breeds : List<String>,
    val id : String,
    val url : String,
    val width : Int,
    val height : Int
)