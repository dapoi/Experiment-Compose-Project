package com.dapascript.corenavigation.di

import com.dapascript.corenavigation.foundation.NavGraphInjector
import com.dapascript.corenavigation.graph.CardNavGraph
import com.dapascript.corenavigation.graph.MainNavGraph
import com.dapascript.corenavigation.graph.PagingNavGraph
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NavModule {

    @Provides
    fun provideAllGraph(
        mainNavGraph: MainNavGraph,
        cardNavGraph: CardNavGraph,
        pagingNavGraph: PagingNavGraph
    ) = NavGraphInjector(
        listOf(
            mainNavGraph,
            cardNavGraph,
            pagingNavGraph
        )
    )
}