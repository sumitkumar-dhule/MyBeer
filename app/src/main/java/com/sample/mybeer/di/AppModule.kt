package com.sample.mybeer.di

import com.sample.common.Constants
import com.sample.mybeer.data.remote.BeerApi
import com.sample.mybeer.data.repository.BeerRepositoryImpl
import com.sample.mybeer.domain.repository.BeerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBeerApi(): BeerApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BeerApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBeerRepository(api: BeerApi): BeerRepository {
        return BeerRepositoryImpl(api)
    }
}