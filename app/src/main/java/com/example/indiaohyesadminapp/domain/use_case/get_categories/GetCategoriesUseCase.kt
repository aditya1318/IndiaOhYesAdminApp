package com.example.indiaohyesadminapp.domain.use_case.get_categories

import com.example.indiaohyesadminapp.common.Resource
import com.example.indiaohyesadminapp.data.remote.categorydto.toCategory
import com.example.indiaohyesadminapp.domain.model.Category
import com.example.indiaohyesadminapp.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: CategoryRepository
){

    operator fun invoke(): Flow<Resource<List<Category>>> = flow {

        try {
        emit(Resource.Loading())
            val categories = repository.getCategories().map { it -> it.toCategory() }

            emit(Resource.Success(categories))
        }catch (e:HttpException){
            emit(Resource.Error<List<Category>>(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e:IOException){
            emit(Resource.Error<List<Category>>("Couldn't reach the server, please check your internet connection"))
        }

    }

}