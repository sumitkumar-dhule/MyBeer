package com.sample.mybeer.domain.repository

import com.sample.mybeer.data.remote.dto.BeerDetailsDto
import com.sample.mybeer.data.remote.dto.BeerDto
import com.sample.mybeer.domain.model.BeerDetails

interface BeerRepository {

    suspend fun getBeers(): List<BeerDto>

    suspend fun getBeerById(beerId: String): BeerDetailsDto
}