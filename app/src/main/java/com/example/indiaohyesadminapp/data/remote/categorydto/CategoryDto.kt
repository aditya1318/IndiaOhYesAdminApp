package com.example.indiaohyesadminapp.data.remote.categorydto

import com.example.indiaohyesadminapp.domain.model.Category

data class CategoryDto(
    val __v: Int,
    val _id: String,
    val description: String,
    val image: String,
    val title: String
)

fun CategoryDto.toCategory():Category{
    return Category(
        _id =  _id,
        description = description,
        image = image,
        title = title
    )
}