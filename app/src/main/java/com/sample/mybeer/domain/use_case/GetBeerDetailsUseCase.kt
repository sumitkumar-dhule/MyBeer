package com.sample.mybeer.domain.use_case

import com.sample.common.Resource
import com.sample.mybeer.data.remote.dto.toBeerDetails
import com.sample.mybeer.domain.model.BeerDetails
import com.sample.mybeer.domain.repository.BeerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBeerDetailsUseCase @Inject constructor(private val repository: BeerRepository) {

    operator fun invoke(beerId: String): Flow<Resource<BeerDetails>> = flow {
        try {
            emit(Resource.Loading<BeerDetails>())
            val beerDetails = repository.getBeerById(beerId).toBeerDetails()
            emit(Resource.Success<BeerDetails>(beerDetails))
        } catch (e: HttpException) {
            emit(Resource.Error<BeerDetails>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<BeerDetails>("Couldn't reach server. Check your internet connection."))
        }
    }

}