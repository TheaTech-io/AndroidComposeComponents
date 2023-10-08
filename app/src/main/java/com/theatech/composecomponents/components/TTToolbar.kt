package com.theatech.composecomponents.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.theatech.composecomponents.R
import com.theatech.composecomponents.clickableWithoutRipple
import com.theatech.composecomponents.sdp

@Composable
fun TTToolbar(
    title: String,
    isBackButtonVisible: Boolean = false,
    endIcon: Int? = null,
    textNearIcon: Int? = null,
    onBackClick: () -> Unit = {},
    onEndIconClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 56.sdp)
    ) {
        if (isBackButtonVisible) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.CenterStart)
                    .clickableWithoutRipple { onBackClick() }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(16.sdp)
                )
            }
        }

        Row(
            modifier = Modifier.align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically
        ) {
            textNearIcon?.let {
                Box {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = "",
                        modifier = Modifier.padding(end = 8.sdp)
                    )
                }
            }

            TTText(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                align = TextAlign.Center,
                color = Color.DarkGray
            )
        }

        endIcon?.let {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.CenterEnd)
                    .clickableWithoutRipple { onEndIconClick() }
            ) {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(16.sdp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TTToolbarPreview() {
    TTToolbar(title = "Title")
}

@Preview(showBackground = true)
@Composable
fun TTToolbarWithBackIconPreview() {
    TTToolbar(
        title = "Title",
        isBackButtonVisible = true,
        onBackClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun TTToolbarWithEndIconPreview() {
    TTToolbar(
        title = "Title",
        endIcon = R.drawable.ic_back,
        onBackClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun TTToolbarWithTextNearIconPreview() {
    TTToolbar(
        title = "Title",
        textNearIcon = R.drawable.ic_back,
        onBackClick = {}
    )
}