package com.example.grandgaming.DataLayer.Retrofit

import com.example.grandgaming.DataLayer.Model.Cat
import retrofit2.Response
import retrofit2.http.GET

interface CatApiService {
    @GET("v1/images/search?limit=10")
    suspend fun getCats(): Response<List<Cat>>
}