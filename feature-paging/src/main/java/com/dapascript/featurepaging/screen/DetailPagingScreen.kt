package com.dapascript.featurepaging.screen

import androidx.compose.runtime.Composable
import com.dapascript.corenavigation.foundation.AppNavigator
import com.dapascript.coreutils.base.BaseScreen

@Composable
fun DetailPagingScreen(navigator: AppNavigator) {

    BaseScreen(
        title = "Detail Paging Screen",
        navigateBack = { navigator.navigateUp() }
    ) {

    }
}