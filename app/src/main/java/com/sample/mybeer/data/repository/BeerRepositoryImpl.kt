package com.sample.mybeer.data.repository

import com.sample.mybeer.data.remote.BeerApi
import com.sample.mybeer.data.remote.dto.BeerDetailsDto
import com.sample.mybeer.data.remote.dto.BeerDto
import com.sample.mybeer.domain.repository.BeerRepository
import javax.inject.Inject

class BeerRepositoryImpl@Inject constructor(private val beerApi: BeerApi): BeerRepository {
    override suspend fun getBeers(): List<BeerDto> {
        return beerApi.getBeers()
    }

    override suspend fun getBeerById(beerId: String): BeerDetailsDto {
        return beerApi.getBeerById(beerId).last()
    }
}