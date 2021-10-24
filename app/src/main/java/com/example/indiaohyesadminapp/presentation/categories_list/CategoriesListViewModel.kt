package com.example.indiaohyesadminapp.presentation.categories_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.indiaohyesadminapp.common.Resource
import com.example.indiaohyesadminapp.domain.use_case.get_categories.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CategoriesListViewModel @Inject constructor(
private val getCategoriesUseCase :GetCategoriesUseCase
) : ViewModel() {

private val _state = mutableStateOf<CategoriesListState>(CategoriesListState())
val state: State<CategoriesListState> = _state

    init {
        getCategories()
    }


    private fun getCategories(){
        getCategoriesUseCase().onEach { result ->

            when(result){
                is Resource.Success -> {
                    _state.value = CategoriesListState(categories = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CategoriesListState(error = result.msg ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CategoriesListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}