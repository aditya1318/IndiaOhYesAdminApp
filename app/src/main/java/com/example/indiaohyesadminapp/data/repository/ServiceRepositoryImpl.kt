package com.example.indiaohyesadminapp.data.repository

import com.example.indiaohyesadminapp.data.remote.IndiaOhYesApi
import com.example.indiaohyesadminapp.data.remote.servicedto.ServiceDto
import com.example.indiaohyesadminapp.domain.model.Service
import com.example.indiaohyesadminapp.domain.repository.ServiceRepository
import javax.inject.Inject

class ServiceRepositoryImpl @Inject constructor(
    private val api : IndiaOhYesApi

):ServiceRepository {
    override suspend fun getAllServicesByCategoryId(category_id: String): List<ServiceDto> {
        return api.getServiceByCategoryId(category_id)
    }

    override suspend fun getServiceById(service_id: String): ServiceDto {
        return api.getServiceById(service_id)
    }
}