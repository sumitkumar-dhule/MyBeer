package com.sample.mybeer.domain.model

import com.sample.mybeer.data.remote.dto.Ingredients
import com.sample.mybeer.data.remote.dto.Volume

data class BeerDetails(
    val abv: Double,
    val brewers_tips: String,
    val description: String,
    val first_brewed: String,
    val food_pairing: List<String>,
    val id: Int,
    val imageUrl: String,
    val ingredients: Ingredients,
    val name: String,
    val ph: Double,
    val tagline: String,
    val volume: Volume
)