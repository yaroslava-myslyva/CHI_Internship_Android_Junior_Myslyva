package com.example.chi_internship_android_junior_myslyva

import retrofit2.Response
import retrofit2.http.GET

interface AnimalsApi {
    @GET("/animals/rand/10/")
    suspend fun getResponseItem(): Response<List<Animal>>
}