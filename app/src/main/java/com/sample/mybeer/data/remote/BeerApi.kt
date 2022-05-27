package com.sample.mybeer.data.remote

import com.sample.mybeer.data.remote.dto.BeerDetailsDto
import com.sample.mybeer.data.remote.dto.BeerDto
import retrofit2.http.GET
import retrofit2.http.Path

interface BeerApi {

    @GET("v2/beers")
    suspend fun getBeers(): List<BeerDto>

    @GET("v2/beer/{beerId}")
    suspend fun getBeerById(@Path("beerId") beerId: String): List<BeerDetailsDto>

}