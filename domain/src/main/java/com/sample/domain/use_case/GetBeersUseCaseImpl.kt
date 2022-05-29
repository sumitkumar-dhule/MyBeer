package com.sample.domain.use_case

import com.sample.common.Resource
import com.sample.domain.model.Beer
import com.sample.domain.repository.BeerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBeersUseCaseImpl @Inject constructor(private val repository: BeerRepository) :
    GetBeersUseCase {

    override operator fun invoke(): Flow<Resource<List<Beer>>> = flow {
        try {
            emit(Resource.Loading<List<Beer>>())
            val beers = repository.getBeers()
            emit(Resource.Success<List<Beer>>(beers))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Beer>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Beer>>("Couldn't reach server. Check your internet connection."))
        }
    }
}