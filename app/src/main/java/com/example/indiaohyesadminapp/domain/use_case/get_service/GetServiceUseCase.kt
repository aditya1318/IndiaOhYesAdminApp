package com.example.indiaohyesadminapp.domain.use_case.get_service

import com.example.indiaohyesadminapp.common.Resource
import com.example.indiaohyesadminapp.data.remote.servicedto.toService
import com.example.indiaohyesadminapp.domain.model.Category
import com.example.indiaohyesadminapp.domain.model.Service
import com.example.indiaohyesadminapp.domain.repository.ServiceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetServiceUseCase  @Inject constructor(
    private val repository : ServiceRepository
){

    operator  fun invoke(service_id:String): Flow<Resource<Service>> = flow{
        try {
            emit(Resource.Loading<Service>())
            val service = repository.getServiceById(service_id = service_id).toService()

            emit(Resource.Success<Service>(service))
        }catch (e: HttpException){
            emit(Resource.Error<Service>(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<Service>("Couldn't reach the server, please check your internet connection"))
        }
    }
}