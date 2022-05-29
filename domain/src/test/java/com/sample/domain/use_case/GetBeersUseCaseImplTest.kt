package com.sample.domain.use_case

import com.sample.domain.DummyRepository
import com.sample.domain.getDummyBeer
import com.sample.domain.model.Beer
import com.sample.domain.repository.BeerRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GetBeersUseCaseImplTest {

    private lateinit var getBeersUseCaseImpl: GetBeersUseCaseImpl
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")
    lateinit var repository: BeerRepository

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        repository = DummyRepository()
        getBeersUseCaseImpl = GetBeersUseCaseImpl(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun `Successful Result with List of Beers`() {
        runBlocking {
            var beer: Beer? = null
            val output = getBeersUseCaseImpl.invoke()
            output.collect {
               beer = it.data?.first()
            }
            assertEquals(getDummyBeer(), beer)
        }
    }


}

