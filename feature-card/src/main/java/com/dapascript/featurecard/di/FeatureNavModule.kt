package com.dapascript.featurecard.di

import com.dapascript.corenavigation.graph.CardNavGraph
import com.dapascript.featurecard.navigation.CardNavGraphImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class FeatureNavModule {

    @Provides
    fun provideCardNavGraphImpl(): CardNavGraph = CardNavGraphImpl()
}