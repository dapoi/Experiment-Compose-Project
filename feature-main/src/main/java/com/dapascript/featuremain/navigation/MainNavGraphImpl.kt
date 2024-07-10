package com.dapascript.featuremain.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dapascript.corenavigation.foundation.AppNavigator
import com.dapascript.corenavigation.graph.MainNavGraph
import com.dapascript.corenavigation.graph.MainNavGraphRoute
import com.dapascript.featuremain.navigation.route.MainRoute
import com.dapascript.featuremain.screen.MainScreen
import javax.inject.Inject

class MainNavGraphImpl @Inject constructor() : MainNavGraph() {

    override fun createGraph(navigator: AppNavigator, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation<MainNavGraphRoute>(
            startDestination = MainRoute
        ) { composable<MainRoute> { MainScreen(navigator) } }
    }

    override fun getMainRoute() = MainRoute
}