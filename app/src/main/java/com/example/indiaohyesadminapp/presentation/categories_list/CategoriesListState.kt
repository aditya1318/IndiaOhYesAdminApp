package com.example.indiaohyesadminapp.presentation.categories_list

import com.example.indiaohyesadminapp.domain.model.Category

data class CategoriesListState(
    val isLoading:Boolean = false,
    val categories :List<Category> = emptyList(),
    val error :String = ""
)
