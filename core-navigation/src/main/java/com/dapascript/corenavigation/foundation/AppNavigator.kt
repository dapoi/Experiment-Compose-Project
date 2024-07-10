package com.dapascript.corenavigation.foundation

import androidx.navigation.NavHostController
import androidx.navigation.toRoute

class AppNavigator(
    val navController: NavHostController,
    val navGraphs: List<FeatureNavGraph>
) {

    fun navigate(
        route: Any,
        popUpTo: Any? = null,
        isInclusive: Boolean = false,
        isLaunchSingleTop: Boolean = false
    ) {
        navController.navigate(route) {
            popUpTo?.let {
                this.popUpTo(it) { inclusive = isInclusive }
            }
            launchSingleTop = isLaunchSingleTop
        }
    }

    fun navigateUp() = navController.navigateUp()

    inline fun <reified T> getCurrentRoute() = navController.currentBackStackEntry?.toRoute<T>()

    inline fun <reified NavGraph : FeatureNavGraph> getNavGraph() = navGraphs.find { it is NavGraph } as NavGraph
}