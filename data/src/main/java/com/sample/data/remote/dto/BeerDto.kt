package com.sample.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.sample.domain.model.Beer

data class BeerDto(
    val abv: Double,
    @SerializedName("brewers_tips")
    val brewersTips: String,
    val description: String,
    val first_brewed: String,
    val food_pairing: List<String>,
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    val name: String,
    val ph: Double,
    val tagline: String,
    val volume: Volume
)

fun BeerDto.toBeer(): com.sample.domain.model.Beer {
    return com.sample.domain.model.Beer(
        id = id,
        description = description,
        imageUrl = imageUrl,
        name = name,
        tagline = tagline
    )
}