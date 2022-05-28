package com.sample.mybeer.presentation.beer_list

import com.sample.domain.model.Beer

data class BeerListState(
    val isLoading: Boolean = false,
    val beers: List<Beer> = emptyList(),
    val error: String = ""
)
