package com.example.indiaohyesadminapp.data.remote.servicedto

import com.example.indiaohyesadminapp.domain.model.Service

data class ServiceDto(
    val __v: Int,
    val _id: String,
    val category: String,
    val description: String,
    val image: String,
    val summary: String,
    val title: String
)

fun ServiceDto.toService():Service{
    return (Service(
        _id = _id,
        description = description,
        image = image,
        summary = summary,
        title = title
    ))
}