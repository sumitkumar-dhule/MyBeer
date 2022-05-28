package com.sample.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.sample.domain.model.BeerDetails

data class BeerDetailsDto(
    val abv: Double,
    val brewers_tips: String,
    val description: String,
    val first_brewed: String,
    val food_pairing: List<String>,
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    val ingredients: Ingredients,
    val name: String,
    val ph: Double,
    val tagline: String,
    val volume: Volume
)

fun BeerDetailsDto.toBeerDetails(): BeerDetails {
    return BeerDetails(
        id = id,
        description = description,
        imageUrl = imageUrl,
        name = name,
        tagline = tagline,
        food_pairing = food_pairing,
        brewers_tips = brewers_tips,
        abv = abv,
        first_brewed = first_brewed,
        ph = ph,
    )
}