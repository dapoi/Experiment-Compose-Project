package com.dapascript.corenavigation.graph

import com.dapascript.corenavigation.foundation.FeatureNavGraph
import kotlinx.serialization.Serializable

@Serializable
object CardNavGraphRoute

abstract class CardNavGraph : FeatureNavGraph() {
    abstract fun getCardRoute(): Any
}