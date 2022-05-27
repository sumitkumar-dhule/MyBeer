package com.sample.mybeer.presentation.beer_detail

import com.sample.mybeer.domain.model.BeerDetails

data class BeerDetailState(
    val isLoading: Boolean = false,
    val beer: BeerDetails? = null,
    val error: String = ""
)
