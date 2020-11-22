package com.example.imagesearchapp.di.components

import com.example.imagesearchapp.base.ApplicationComponent
import com.example.imagesearchapp.di.FragmentScope
import com.example.imagesearchapp.di.modules.FragmentModule
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {


}