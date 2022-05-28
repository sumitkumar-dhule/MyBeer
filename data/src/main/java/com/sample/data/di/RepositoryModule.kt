package com.sample.data.di

import com.sample.data.repository.BeerRepositoryImpl
import com.sample.domain.repository.BeerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindBeerRepository(beerRepository: BeerRepositoryImpl): BeerRepository
}