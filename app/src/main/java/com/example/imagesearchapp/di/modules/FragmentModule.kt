package com.example.imagesearchapp.di.modules

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imagesearchapp.base.BaseFragment
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)

}