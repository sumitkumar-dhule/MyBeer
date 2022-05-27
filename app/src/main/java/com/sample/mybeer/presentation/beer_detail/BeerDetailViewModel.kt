package com.sample.mybeer.presentation.beer_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.mybeer.common.Constants
import com.sample.mybeer.common.Resource
import com.sample.mybeer.domain.use_case.GetBeerDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BeerDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetBeerDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(BeerDetailState())
    val state: State<BeerDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_BEER_ID)?.let { coinId ->
            getBeer(coinId)
        }
    }

    private fun getBeer(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = BeerDetailState(beer = result.data)
                }
                is Resource.Error -> {
                    _state.value = BeerDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = BeerDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}