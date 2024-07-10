package com.dapascript.featurepaging.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dapascript.corenavigation.foundation.AppNavigator
import com.dapascript.corenavigation.graph.PagingNavGraph
import com.dapascript.corenavigation.graph.PagingNavGraphRoute
import com.dapascript.featurepaging.navigation.route.DetailRoute
import com.dapascript.featurepaging.navigation.route.ListRoute
import com.dapascript.featurepaging.screen.DetailPagingScreen
import com.dapascript.featurepaging.screen.ListPagingScreen
import javax.inject.Inject

class PagingNavGraphImpl @Inject constructor() : PagingNavGraph() {

    override fun createGraph(navigator: AppNavigator, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation<PagingNavGraphRoute>(startDestination = ListRoute) {
            composable<ListRoute> { ListPagingScreen(navigator) }
            composable<DetailRoute> { DetailPagingScreen(navigator) }
        }
    }

    override fun getListPagingRoute() = ListRoute

    override fun getDetailPagingRoute(id: String) = DetailRoute(id)
}