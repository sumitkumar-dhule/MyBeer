package com.sample.domain.di

import com.sample.domain.repository.BeerRepository
import com.sample.domain.use_case.GetBeerDetailsUseCase
import com.sample.domain.use_case.GetBeersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

/*
    @ViewModelScoped
    @Provides
    fun provideGetBeerDetailsUseCase(repository: BeerRepository): GetBeerDetailsUseCase {
        return GetBeerDetailsUseCase(repository)
    }

    @ViewModelScoped
    @Provides
    fun provideGetBeersUseCase(repository: BeerRepository): GetBeersUseCase {
        return GetBeersUseCase(repository)
    }
*/

}