package com.example.grandgaming.DataLayer.Repo

import com.example.grandgaming.Common.State.State
import com.example.grandgaming.DataLayer.Model.Cat
import com.example.grandgaming.DataLayer.Retrofit.CatApiService
import javax.inject.Inject

class CatRepository @Inject constructor(
    private val apiService: CatApiService
) {

    suspend fun getCatList(): State<List<Cat>> {
        return try {
            val response = apiService.getCats()
            if (response.isSuccessful) {
                response.body()?.let {
                    State.Success(it)
                } ?: State.Error("No data found")
            } else {
                State.Error(response.message())
            }
        } catch (e: Exception) {
            State.Error(e.localizedMessage ?: "An unexpected error occurred")
        }
    }
}
