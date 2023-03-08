package com.example.whooshtale.ui.common

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import com.example.whooshtale.R

@Composable
fun WavesAnimation() {

    val waves = listOf(
        remember { Animatable(0f) },
        remember { Animatable(0f) },
        remember { Animatable(0f) },
        remember { Animatable(0f) },
    )

    val animationSpec = infiniteRepeatable<Float>(
        animation = tween(4000, easing = FastOutLinearInEasing),
        repeatMode = RepeatMode.Restart,
    )

    waves.forEachIndexed { index, animatable ->
        LaunchedEffect(animatable) {
            delay(index * 1000L)
            animatable.animateTo(
                targetValue = 1f, animationSpec = animationSpec
            )
        }
    }

    val dys = waves.map { it.value }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Waves
        dys.forEach { dy ->
            Box(
                Modifier
                    .size(50.dp)
                    .align(Alignment.Center)
                    .graphicsLayer {
                        scaleX = dy * 4 + 1
                        scaleY = dy * 4 + 1
                        alpha = 1 - dy
                    },
            ) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(color = Color.Yellow, shape = CircleShape)
                )
            }
        }

        // Wand icon
        Box(
            Modifier
                .size(50.dp)
                .align(Alignment.Center)
                .background(color = Color.Yellow, shape = CircleShape)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_wand),
                "",
                tint = Color.LightGray,
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center),

            )
        }

    }

}