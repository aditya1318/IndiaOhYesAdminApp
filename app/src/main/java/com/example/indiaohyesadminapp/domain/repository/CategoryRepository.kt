package com.example.indiaohyesadminapp.domain.repository

import com.example.indiaohyesadminapp.data.remote.categorydto.CategoryDto

interface CategoryRepository  {

    suspend fun getCategoryById(category_id:String):CategoryDto
    suspend fun getCategories():List<CategoryDto>
}