package com.dapascript.featurecard.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dapascript.corenavigation.foundation.AppNavigator
import com.dapascript.coreutils.base.BaseScreen

@Composable
fun CardScreen(navigator: AppNavigator) {

    BaseScreen(
        title = "Card Screen",
        navigateBack = { navigator.navigateUp() }
    ) {
        CardComponent(it)
    }
}

@Composable
private fun CardComponent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier.fillMaxSize().padding(paddingValues),
        horizontalAlignment = CenterHorizontally
    ) {
        FlipCard()
    }
}

@Composable
private fun FlipCard() {
    var rotated by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (rotated) 180f else 0f,
        animationSpec = tween(500),
        label = "rotation"
    )
    val animateFront by animateFloatAsState(
        targetValue = if (rotated) 0f else 1f,
        animationSpec = tween(500),
        label = "animateFront"
    )
    val animateBack by animateFloatAsState(
        targetValue = if (rotated) 1f else 0f,
        animationSpec = tween(500),
        label = "animateBack"
    )

    Text(text = "Click on the card to flip it", textAlign = TextAlign.Center)
    Card(
        modifier = Modifier
            .height(220.dp)
            .fillMaxWidth()
            .padding(16.dp)
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 8 * density
            }
            .clickable { rotated = !rotated },
        shape = RoundedCornerShape(8.dp),
        colors = cardColors(
            containerColor = colorScheme.primary,
            contentColor = colorScheme.surface
        )
    ) {
        if (!rotated) {
            Box(
                modifier = Modifier.fillMaxSize().graphicsLayer(alpha = animateFront, rotationY = rotation),
                contentAlignment = Center
            ) {
                Text(text = "Front Card")
            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize().graphicsLayer(alpha = animateBack, rotationY = rotation),
                contentAlignment = Center
            ) {
                Text(
                    text = "Back Card"
                )
            }
        }
    }
}