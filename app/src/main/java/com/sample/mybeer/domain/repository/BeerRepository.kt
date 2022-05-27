package com.sample.mybeer.domain.repository

import com.sample.mybeer.domain.model.Beer
import com.sample.mybeer.domain.model.BeerDetails

interface BeerRepository {

    suspend fun getBeers(): List<Beer>

    suspend fun getBeerById(beerId: String): BeerDetails
}