package com.example.imagesearchapp.ui.searchImage

import com.example.imagesearchapp.models.ImageDataResponse
import com.example.imagesearchapp.network.NetworkService
import retrofit2.Response
import javax.inject.Inject

class SearchImageRepository @Inject constructor(
    private val networkService: NetworkService
) {

    suspend fun getSearchedImage(searchedKeyWord: String): Response<ImageDataResponse> {
        return networkService.getSearchedImage(searchedKeyWord)
    }
}