package com.dapascript.featuremain.di

import com.dapascript.corenavigation.graph.MainNavGraph
import com.dapascript.featuremain.navigation.MainNavGraphImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class FeatureNavModule {

    @Provides
    fun provideMainNavGraphImpl(): MainNavGraph = MainNavGraphImpl()
}