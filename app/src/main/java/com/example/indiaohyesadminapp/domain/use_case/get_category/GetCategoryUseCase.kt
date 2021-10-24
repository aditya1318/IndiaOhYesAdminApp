package com.example.indiaohyesadminapp.domain.use_case.get_category

import com.example.indiaohyesadminapp.common.Resource
import com.example.indiaohyesadminapp.data.remote.categorydto.toCategory
import com.example.indiaohyesadminapp.domain.model.Category
import com.example.indiaohyesadminapp.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(
    private val repository: CategoryRepository
){

    operator fun invoke(category_id:String): Flow<Resource<Category>> = flow {

        try {
            emit(Resource.Loading<Category>())
            val category = repository.getCategoryById(category_id).toCategory()

            emit(Resource.Success(category))
        }catch (e: HttpException){
            emit(Resource.Error<Category>(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<Category>("Couldn't reach the server, please check your internet connection"))
        }

    }
}