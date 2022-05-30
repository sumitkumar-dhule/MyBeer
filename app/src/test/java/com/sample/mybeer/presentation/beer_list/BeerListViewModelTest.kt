package com.sample.mybeer.presentation.beer_list

import com.sample.common.Resource
import com.sample.domain.model.Beer
import com.sample.domain.use_case.GetBeersUseCase
import com.sample.mybeer.BaseViewModelTest
import com.sample.mybeer.getDummyBeer
import com.sample.mybeer.runBlockingMainTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class BeerListViewModelTest : BaseViewModelTest() {

    private lateinit var beerListViewModel: BeerListViewModel

    @Mock
    lateinit var getBeersUseCase: GetBeersUseCase

    @Before
    fun setUp() {
        beerListViewModel = BeerListViewModel(getBeersUseCase)
    }

    @Test
    fun `Successful Result with List of Beers`() = runBlockingMainTest {
        val inputFlow: Flow<Resource<List<Beer>>> =
            flowOf(Resource.Success(listOf(getDummyBeer())))
        whenever(getBeersUseCase.invoke()).thenReturn(inputFlow)
        beerListViewModel.getBeers()
        assertEquals(getDummyBeer(), beerListViewModel.state.value.beers.first())
    }

}