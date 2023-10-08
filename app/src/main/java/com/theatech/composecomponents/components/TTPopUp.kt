package com.theatech.composecomponents.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.theatech.composecomponents.R
import com.theatech.composecomponents.sdp
import com.theatech.composecomponents.ssp

data class TTPopUpTitle(
    val title: String,
    val titleColor: Color = Color.White,
    val titleFontSize: TextUnit = TextUnit.Unspecified,
    val titleLineHeight: TextUnit = TextUnit.Unspecified
)

data class TTPopUpDesc(
    val desc: String,
    val descColor: Color = Color.White,
    val descFontSize: TextUnit = TextUnit.Unspecified,
    val descLineHeight: TextUnit = TextUnit.Unspecified,
)

data class TTPopUpButton(
    val text: String,
    val color: Color = Color.White,
    val fontSize: TextUnit = TextUnit.Unspecified,
)

@Composable
fun TTPopUp(
    icon: Int? = null,
    title: TTPopUpTitle? = null,
    desc: TTPopUpDesc? = null,
    topButton: TTPopUpButton,
    topButtonClick: () -> Unit = {},
    bottomButton: TTPopUpButton? = null,
    bottomButtonClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.DarkGray)
                .alpha(0.5f)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 33.sdp)
                .background(color = Color.Black, shape = RoundedCornerShape(12.sdp))
                .align(alignment = Alignment.Center)
                .padding(
                    start = 20.sdp,
                    end = 20.sdp,
                    top = if (icon != null) 56.sdp else 36.sdp,
                    bottom = 36.sdp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            icon?.let {
                Image(
                    modifier = Modifier
                        .size(165.sdp),
                    painter = painterResource(id = it),
                    colorFilter = ColorFilter.tint(Color.White),
                    contentDescription = ""
                )
            }
            title?.let {
                TTText(
                    modifier = Modifier.padding(top = if (icon != null) 40.sdp else 0.sdp),
                    text = it.title,
                    color = it.titleColor,
                    align = TextAlign.Center,
                    fontSize = it.titleFontSize,
                    lineHeight = it.titleLineHeight
                )
            }
            desc?.let {
                TTText(
                    modifier = Modifier.padding(top = if (title != null) 14.sdp else if (icon != null) 40.sdp else 0.sdp),
                    text = it.desc,
                    color = it.descColor,
                    align = TextAlign.Center,
                    fontSize = it.descFontSize,
                    lineHeight = it.descLineHeight
                )
            }
            TTButton(
                modifier = Modifier.padding(top = 42.sdp),
                onClick = { topButtonClick() },
                text = topButton.text,
                textColor = topButton.color,
                textSize = topButton.fontSize
            )
            bottomButton?.let {
                TTButton(
                    modifier = Modifier.padding(top = 16.sdp),
                    onClick = { bottomButtonClick() },
                    text = it.text,
                    textColor = it.color,
                    textSize = it.fontSize
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TTErrorPopUpPreview() {
    TTPopUp(
        title = TTPopUpTitle(
            title = "Message",
            titleColor = Color.White,
            titleFontSize = 30.ssp,
            titleLineHeight = 32.ssp
        ),
        topButton = TTPopUpButton(
            text = "Button",
            color = Color.White,
            fontSize = 16.ssp
        ),
    )
}

@Composable
@Preview(showBackground = true)
fun TTErrorPopUpWithIconPreview() {
    TTPopUp(
        icon = R.drawable.ic_back,
        title = TTPopUpTitle(
            title = "Message",
            titleColor = Color.White,
            titleFontSize = 30.ssp,
            titleLineHeight = 32.ssp
        ),
        topButton = TTPopUpButton(
            text = "Button",
            color = Color.White,
            fontSize = 16.ssp
        ),
    )
}