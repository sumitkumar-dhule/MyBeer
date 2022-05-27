package com.sample.mybeer.domain.model

data class Beer(
    val description: String,
    val id: Int,
    val imageUrl: String,
    val name: String,
    val tagline: String
)