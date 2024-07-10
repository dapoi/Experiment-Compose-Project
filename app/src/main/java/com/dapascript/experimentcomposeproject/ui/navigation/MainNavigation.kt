package com.dapascript.experimentcomposeproject.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.dapascript.corenavigation.foundation.AppNavigator
import com.dapascript.corenavigation.foundation.FeatureNavGraph
import com.dapascript.corenavigation.graph.MainNavGraphRoute

@Composable
fun MainNavigation(allGraph: List<FeatureNavGraph>) {
    val navController = rememberNavController()
    val navGraphs = remember { allGraph }
    val navigator = remember {
        AppNavigator(
            navController = navController,
            navGraphs = navGraphs
        )
    }

    NavHost(navController = navController, startDestination = MainNavGraphRoute) {
        navGraphs.forEach { listGraph ->
            listGraph.createGraph(navigator, this)
        }
    }
}