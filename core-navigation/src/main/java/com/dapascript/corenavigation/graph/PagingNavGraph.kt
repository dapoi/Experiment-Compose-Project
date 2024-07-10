package com.dapascript.corenavigation.graph

import com.dapascript.corenavigation.foundation.FeatureNavGraph
import kotlinx.serialization.Serializable

@Serializable
object PagingNavGraphRoute

abstract class PagingNavGraph : FeatureNavGraph() {
    abstract fun getListPagingRoute(): Any
    abstract fun getDetailPagingRoute(id: String): Any
}