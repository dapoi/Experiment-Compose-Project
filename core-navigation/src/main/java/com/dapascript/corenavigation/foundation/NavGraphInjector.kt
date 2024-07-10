package com.dapascript.corenavigation.foundation

import javax.inject.Inject

class NavGraphInjector @Inject constructor(
    private val navGraphs: List<FeatureNavGraph>
) {

    fun injectGraphs() = navGraphs
}