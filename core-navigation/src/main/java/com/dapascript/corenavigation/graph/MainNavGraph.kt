package com.dapascript.corenavigation.graph

import com.dapascript.corenavigation.foundation.FeatureNavGraph
import kotlinx.serialization.Serializable

@Serializable
object MainNavGraphRoute

abstract class MainNavGraph : FeatureNavGraph() {
    abstract fun getMainRoute(): Any
}