package com.dapascript.featurepaging.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import com.dapascript.corenavigation.foundation.AppNavigator
import com.dapascript.coreutils.base.BaseScreen
import com.dapascript.featurepaging.navigation.route.DetailRoute
import com.dapascript.featurepaging.navigation.route.ListRoute

@Composable
fun ListPagingScreen(navigator: AppNavigator) {

    BaseScreen(
        title = "List Paging Screen",
        navigateBack = { navigator.navigateUp() }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Center
        ) {
            Button(
                onClick = {
                    navigator.navigate(
                        route = DetailRoute("1"),
                        popUpTo = ListRoute,
                        isInclusive = true
                    )
                }
            ) {
                Text(text = "Go to Detail")
            }
        }
    }
}