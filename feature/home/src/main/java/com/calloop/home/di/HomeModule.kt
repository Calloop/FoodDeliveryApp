package com.calloop.home.di

import com.calloop.home.presentation.viewmodel.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object HomeModule {

    @Provides
    @ViewModelScoped
    fun provideRestaurantRepository(
        apiService: ApiService
    ): RestaurantRepository = RestaurantRepositoryImpl(apiService)

    @Provides
    @ViewModelScoped
    fun provideHomeViewModel(
        repository: RestaurantRepository
    ): HomeViewModel = HomeViewModel(repository)
}