package com.example.indiaohyesadminapp.domain.use_case.get_services

import com.example.indiaohyesadminapp.common.Resource
import com.example.indiaohyesadminapp.data.remote.servicedto.toService
import com.example.indiaohyesadminapp.data.repository.ServiceRepositoryImpl
import com.example.indiaohyesadminapp.domain.model.Category
import com.example.indiaohyesadminapp.domain.model.Service
import com.example.indiaohyesadminapp.domain.repository.ServiceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetServicesUseCase @Inject constructor(
    private val repository: ServiceRepository
) {
    operator fun invoke(category_id:String): Flow<Resource<List<Service>>> = flow {
       try {
              emit(Resource.Loading<List<Service>>())
           val services = repository.getAllServicesByCategoryId(category_id).map { it.toService() }

           emit(Resource.Success<List<Service>>(services))
       }catch (e:HttpException){
           emit(Resource.Error<List<Service>>(e.localizedMessage ?: "An unexpected error occurred"))
       }catch (e: IOException){
           emit(Resource.Error<List<Service>>("Couldn't reach the server, please check your internet connection"))
       }
    }
}