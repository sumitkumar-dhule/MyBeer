package com.sample.mybeer.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.sample.mybeer.domain.model.Beer

data class BeerDto(
    val abv: Double,
    val attenuation_level: Int,
    val brewers_tips: String,
    val contributed_by: String,
    val description: String,
    val ebc: Int,
    val first_brewed: String,
    val food_pairing: List<String>,
    val ibu: Int,
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    val ingredients: Ingredients,
    val name: String,
    val ph: Double,
    val srm: Int,
    val tagline: String,
    val target_fg: Int,
    val target_og: Int,
    val volume: Volume
)

fun BeerDto.toBeer(): Beer {
    return Beer(
        id = id,
        description = description,
        imageUrl = imageUrl,
        name = name,
        tagline = tagline
    )
}