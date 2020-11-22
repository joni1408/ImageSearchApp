package com.example.imagesearchapp.ui.searchImage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.imagesearchapp.base.BaseViewModel
import com.example.imagesearchapp.callback.Resource
import com.example.imagesearchapp.models.ImageDataResponse
import com.example.imagesearchapp.rx.SchedulerProvider
import com.example.imagesearchapp.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch
import retrofit2.Response


class SearchImageViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val searchImageRepository: SearchImageRepository
) : BaseViewModel(
    schedulerProvider, compositeDisposable, networkHelper
) {

    var searchedImagesLD: MutableLiveData<Resource<ImageDataResponse>> = MutableLiveData()

    override fun onCreate() {}


    fun searchImageWithKeyword(keyword: String) = viewModelScope.launch {
        searchedImagesLD.postValue(Resource.loading())
        val response = searchImageRepository.getSearchedImage(keyword)
        searchedImagesLD.postValue(handleSearchImageResponse(response))
    }

    private fun handleSearchImageResponse(response: Response<ImageDataResponse>): Resource<ImageDataResponse> {
        if (response.isSuccessful) {
            response.body().let { resultResponse ->
                return Resource.success(resultResponse)
            }
        }
        return Resource.error(response.body())
    }

}