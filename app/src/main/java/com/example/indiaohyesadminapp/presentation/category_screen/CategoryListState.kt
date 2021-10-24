package com.example.indiaohyesadminapp.presentation.category_screen

import com.example.indiaohyesadminapp.domain.model.Category

data class CategoryListState(
    val isLoading:Boolean = false,
    val category :Category? = null,
    val error :String = ""
)
