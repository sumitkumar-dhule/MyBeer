package com.sample.mybeer.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.sample.mybeer.domain.model.BeerDetails

data class BeerDetailsDto(
    val abv: Double,
    val attenuation_level: Int,
    val brewers_tips: String,
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

fun BeerDetailsDto.toBeerDetails(): BeerDetails {
    return BeerDetails(
        id = id,
        description = description,
        imageUrl = imageUrl,
        name = name,
        tagline = tagline,
        food_pairing = food_pairing,
        ingredients = ingredients,
        brewers_tips = brewers_tips,
        abv = abv,
        first_brewed = first_brewed,
        ph = ph,
        volume = volume
    )
}