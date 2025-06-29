package com.calloop.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _categories = MutableStateFlow(emptyList<String>())
    val categories: StateFlow<List<String>> = _categories.asStateFlow()

    private val _selectedCategory = MutableStateFlow("All")
    val selectedCategory: StateFlow<String> = _selectedCategory.asStateFlow()

    init {
        loadRestaurants()
        loadCategories()
    }

    fun selectCategory(category: String) {
        _selectedCategory.value = category
        loadRestaurants()
    }

    private fun loadRestaurants() {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            try {
                val restaurants = if (selectedCategory.value == "All") {
                    repository.getPopularRestaurants()
                } else {
                    repository.getRestaurantsByCategory(selectedCategory.value)
                }
                _uiState.value = HomeUiState.Success(restaurants)
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error(e.message ?: "Unknown error")
            }
        }
    }

    private fun loadCategories() {
        viewModelScope.launch {
            try {
                _categories.value = listOf("All") + repository.getCategories()
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}

sealed interface HomeUiState {
    object Loading : HomeUiState
    data class Success(val restaurants: List<Restaurant>) : HomeUiState
    data class Error(val message: String) : HomeUiState
}