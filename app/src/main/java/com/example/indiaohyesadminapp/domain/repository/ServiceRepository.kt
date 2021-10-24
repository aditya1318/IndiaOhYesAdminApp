package com.example.indiaohyesadminapp.domain.repository

import com.example.indiaohyesadminapp.data.remote.servicedto.ServiceDto
import com.example.indiaohyesadminapp.domain.model.Service

interface ServiceRepository {
    suspend fun getAllServicesByCategoryId(category_id:String):List<ServiceDto>

    suspend fun getServiceById(service_id :String):ServiceDto

}