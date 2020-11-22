package com.example.imagesearchapp.network

import com.example.imagesearchapp.models.ImageDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET("gallery/search/1")
    suspend fun getSearchedImage(
        @Query("q") searchQuery: String
    ): Response<ImageDataResponse>

}