package com.dapascript.featurepaging.di

import com.dapascript.corenavigation.graph.PagingNavGraph
import com.dapascript.featurepaging.navigation.PagingNavGraphImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class FeatureNavModule {

    @Provides
    fun providePagingNavGraphImpl(): PagingNavGraph = PagingNavGraphImpl()
}