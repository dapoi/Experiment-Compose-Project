package com.dapascript.experimentcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dapascript.corenavigation.foundation.NavGraphInjector
import com.dapascript.experimentcomposeproject.ui.navigation.MainNavigation
import com.dapascript.experimentcomposeproject.ui.theme.ExperimentComposeProjectTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navGraphInjector: NavGraphInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExperimentComposeProjectTheme {
                MainNavigation(navGraphInjector.injectGraphs())
            }
        }
    }
}