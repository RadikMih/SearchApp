package com.searchaddressapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.searchaddressapp.domain.model.AddressInfo
import com.searchaddressapp.domain.repository.SearchRepository
import com.searchaddressapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {

    var state by mutableStateOf(AddressInfoState())
    private var searchJob: Job? = null


    private fun getSearchResult(query: String = state.searchQuery.lowercase()) {
        viewModelScope.launch {

            when (val addressResult = searchRepository.findAddresses(query)) {
                is Resource.Success -> {
                    addressResult.data?.let { addresses ->
                        state = state.copy(
                            addresses = addresses
                        )
                    }
                }

                is Resource.Error -> {}
                is Resource.Loading -> {
                    state = state.copy(isLoading = addressResult.isLoading)
                }
            }
        }
    }

    fun onEvent(event: AddressInfoSearchEvent) {
        when (event) {
            is AddressInfoSearchEvent.OnSearchQueryChange -> {
                state = state.copy(searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500L)
                    getSearchResult()
                }
            }
        }
    }
}

data class AddressInfoState(
    val addresses: List<AddressInfo> = emptyList(),
    val isLoading: Boolean = false,
    val searchQuery: String = ""
)

sealed class AddressInfoSearchEvent {
    data class OnSearchQueryChange(val query: String) : AddressInfoSearchEvent()
}