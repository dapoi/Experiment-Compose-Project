package com.dapascript.featuremain.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.unit.dp
import com.dapascript.corenavigation.foundation.AppNavigator
import com.dapascript.corenavigation.graph.CardNavGraph
import com.dapascript.corenavigation.graph.PagingNavGraph
import com.dapascript.coreutils.base.BaseScreen

@Composable
fun MainScreen(navigator: AppNavigator) {

    BaseScreen(
        title = "Main Screen",
        showIconBack = false,
        navigateBack = {}
    ) {
        val features = remember { listOf("Sample Card", "Sample Paging") }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = spacedBy(8.dp)
        ) {
            items(features) { featureName ->
                MainScreenComponent(featureName) {
                    handleNavigate(navigator, featureName)
                }
            }
        }
    }
}

@Composable
private fun MainScreenComponent(
    featureName: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.primary
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
            text = featureName,
            color = colorScheme.onPrimary,
            textAlign = Center
        )
    }
}

private fun handleNavigate(navigator: AppNavigator, featureName: String) {
    navigator.navigate(
        when {
            featureName.contains("Card") -> navigator.getNavGraph<CardNavGraph>().getCardRoute()
            featureName.contains("Paging") -> navigator.getNavGraph<PagingNavGraph>().getListPagingRoute()
            else -> throw IllegalArgumentException("Feature not found")
        }
    )
}