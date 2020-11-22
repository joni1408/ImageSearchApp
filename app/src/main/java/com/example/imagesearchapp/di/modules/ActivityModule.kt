package com.example.imagesearchapp.di.modules

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imagesearchapp.base.BaseActivity
import com.example.imagesearchapp.base.ViewModelProviderFactory
import com.example.imagesearchapp.rx.SchedulerProvider
import com.example.imagesearchapp.ui.imageDetails.ImageDetailsRepository
import com.example.imagesearchapp.ui.imageDetails.ImageDetailsViewModel
import com.example.imagesearchapp.ui.searchImage.SearchImageRepository
import com.example.imagesearchapp.ui.searchImage.SearchImageViewModel
import com.example.imagesearchapp.utils.NetworkHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideSearchImageViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper, searchImageRepository: SearchImageRepository
    ): SearchImageViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(SearchImageViewModel::class) {
            SearchImageViewModel(
                schedulerProvider,
                compositeDisposable,
                networkHelper,
                searchImageRepository
            )
        }).get(SearchImageViewModel::class.java)

    @Provides
    fun provideImageDetailsViewModel(
        imageDetailsRepository: ImageDetailsRepository
    ): ImageDetailsViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(ImageDetailsViewModel::class) {
            ImageDetailsViewModel(
                imageDetailsRepository
            )
        }).get(ImageDetailsViewModel::class.java)

}