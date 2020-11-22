package com.example.imagesearchapp.di.component


import com.example.imagesearchapp.base.ApplicationComponent
import com.example.imagesearchapp.di.ActivityScope
import com.example.imagesearchapp.di.modules.ActivityModule
import com.example.imagesearchapp.ui.imageDetails.ImageDetailsActivity
import com.example.imagesearchapp.ui.searchImage.SearchImagesActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(newsFeedActivity: SearchImagesActivity)
    fun inject(imageDetailsActivity: ImageDetailsActivity)

}