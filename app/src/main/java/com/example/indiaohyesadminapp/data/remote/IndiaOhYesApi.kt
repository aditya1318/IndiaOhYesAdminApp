package com.example.indiaohyesadminapp.data.remote

import com.example.indiaohyesadminapp.data.remote.categorydto.CategoryDto
import com.example.indiaohyesadminapp.data.remote.categorydto.CategoriesRawData
import com.example.indiaohyesadminapp.data.remote.servicedto.ServiceDto
import retrofit2.http.GET

interface IndiaOhYesApi {

    @GET("categories")
    suspend fun getCategories():CategoriesRawData
    @GET("categories/{category_id}")
    suspend fun getCategoryById(category_id:String):CategoryDto

    @GET("services/getServiceByCategoryId/{category_id}")
    suspend fun getServiceByCategoryId(category_id: String):List<ServiceDto>

    @GET("services/{service_id}")
    suspend fun getServiceById(service_id: String):ServiceDto
}