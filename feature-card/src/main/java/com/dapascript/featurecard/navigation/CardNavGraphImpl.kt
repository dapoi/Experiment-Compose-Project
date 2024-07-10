package com.dapascript.featurecard.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dapascript.corenavigation.foundation.AppNavigator
import com.dapascript.corenavigation.graph.CardNavGraph
import com.dapascript.corenavigation.graph.CardNavGraphRoute
import com.dapascript.featurecard.navigation.route.CardRoute
import com.dapascript.featurecard.screen.CardScreen
import javax.inject.Inject

class CardNavGraphImpl @Inject constructor() : CardNavGraph() {
    override fun createGraph(navigator: AppNavigator, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation<CardNavGraphRoute>(startDestination = CardRoute) {
            composable<CardRoute> { CardScreen(navigator) }
        }
    }

    override fun getCardRoute(): Any = CardRoute
}