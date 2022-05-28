package com.sample.domain

import com.sample.domain.getDummyBeer
import com.sample.domain.getDummyBeerDetails
import com.sample.domain.model.Beer
import com.sample.domain.model.BeerDetails
import com.sample.domain.repository.BeerRepository

class DummyRepository() : BeerRepository {
    override suspend fun getBeers(): List<Beer> {
        return listOf(getDummyBeer())
    }

    override suspend fun getBeerById(beerId: String): BeerDetails {
        return getDummyBeerDetails()
    }

}