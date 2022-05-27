package com.sample.mybeer.data.repository

import com.sample.mybeer.data.remote.BeerApi
import com.sample.mybeer.data.remote.dto.BeerDetailsDto
import com.sample.mybeer.data.remote.dto.BeerDto
import com.sample.mybeer.data.remote.dto.toBeer
import com.sample.mybeer.data.remote.dto.toBeerDetails
import com.sample.mybeer.domain.model.Beer
import com.sample.mybeer.domain.model.BeerDetails
import com.sample.mybeer.domain.repository.BeerRepository
import javax.inject.Inject

class BeerRepositoryImpl@Inject constructor(private val beerApi: BeerApi): BeerRepository {
    override suspend fun getBeers(): List<Beer> {
        return beerApi.getBeers().map { it.toBeer() }
    }

    override suspend fun getBeerById(beerId: String): BeerDetails {
        return beerApi.getBeerById(beerId).map { it.toBeerDetails() }.last()
    }
}