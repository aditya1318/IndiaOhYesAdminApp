package com.example.indiaohyesadminapp.di

import com.example.indiaohyesadminapp.common.Constants
import com.example.indiaohyesadminapp.data.remote.IndiaOhYesApi
import com.example.indiaohyesadminapp.data.repository.CategoryRepositoryImpl
import com.example.indiaohyesadminapp.domain.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideIndiaOhYesApi():IndiaOhYesApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IndiaOhYesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(api: IndiaOhYesApi):CategoryRepository{
        return CategoryRepositoryImpl(api)
    }
}