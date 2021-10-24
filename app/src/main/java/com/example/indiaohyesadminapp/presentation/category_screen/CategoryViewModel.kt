package com.example.indiaohyesadminapp.presentation.category_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.indiaohyesadminapp.common.Constants
import com.example.indiaohyesadminapp.common.Resource
import com.example.indiaohyesadminapp.domain.use_case.get_categories.GetCategoriesUseCase
import com.example.indiaohyesadminapp.domain.use_case.get_category.GetCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
private val getCategoryUseCase: GetCategoryUseCase,
savedStateHandle: SavedStateHandle
) : ViewModel() {

private val _state = mutableStateOf<CategoryListState>(CategoryListState())
val state: State<CategoryListState> = _state

    init {
       savedStateHandle.get<String>(Constants.PARAM_CATEGORY_ID)?.let { category_id ->
           getCategoryUseCase(category_id)
       }
    }


    private fun getCategory(category_id:String){
        getCategoryUseCase(category_id).onEach { result ->

            when(result){
                is Resource.Success -> {
                    _state.value = CategoryListState(category = result.data)
                }
                is Resource.Error -> {
                    _state.value = CategoryListState(error = result.msg ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CategoryListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}