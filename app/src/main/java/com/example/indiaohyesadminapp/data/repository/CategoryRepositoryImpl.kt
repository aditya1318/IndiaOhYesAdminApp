package com.example.indiaohyesadminapp.data.repository

import com.example.indiaohyesadminapp.data.remote.IndiaOhYesApi
import com.example.indiaohyesadminapp.data.remote.categorydto.CategoryDto
import com.example.indiaohyesadminapp.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val api:IndiaOhYesApi
) :CategoryRepository {
    override suspend fun getCategoryById(category_id: String): CategoryDto {
        return api.getCategoryById(category_id)
    }

    override suspend fun getCategories(): List<CategoryDto> {
        return api.getCategories().categoriesData.categories
    }
}