package com.theatech.composecomponents.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TTProgressBar(
    modifier: Modifier = Modifier,
    progressColor: Color = Color.Black,
    backgroundColor: Color = Color.White,
) {
    val progressAnimationValue by rememberInfiniteTransition(
        label = ""
    ).animateFloat(
        initialValue = 0.0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(animation = tween(1000)),
        label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        /** Lottie Progress Bar */

        /*val composition by rememberLottieComposition(
            LottieCompositionSpec.Asset("error.json"),
        )
        val progress by animateLottieCompositionAsState(
            composition,
            iterations = LottieConstants.IterateForever
        )
        LottieAnimation(
            modifier = Modifier.size(240.sdp),
            composition = composition,
            progress = { progress },
        )*/

        /** Native Progress Bar */
        /*CircularProgressIndicator(
            progress = progressAnimationValue,
            color = progressColor
        )*/
    }
}

@Composable
@Preview(showBackground = true)
fun TTProgressBarPreview() {
    TTProgressBar()
}