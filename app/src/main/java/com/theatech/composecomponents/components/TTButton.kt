package com.theatech.composecomponents.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.theatech.composecomponents.R
import com.theatech.composecomponents.sdp

@Composable
fun TTButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    textColor: Color = Color.White,
    textSize: TextUnit = TextUnit.Unspecified,
    startIcon: Int? = null,
    endIcon: Int? = null,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.shape,
    colors: ButtonColors = ButtonDefaults.buttonColors()
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        colors = colors,
        modifier = modifier.height(64.sdp).fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            startIcon?.let {
                Image(
                    modifier = Modifier.size(24.sdp),
                    painter = painterResource(id = it),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.size(8.sdp))
            }
            TTText(
                text = text,
                color = textColor,
                fontSize = textSize
            )
            endIcon?.let {
                Spacer(modifier = Modifier.size(8.sdp))
                Image(
                    modifier = Modifier.size(24.sdp),
                    painter = painterResource(id = it),
                    contentDescription = ""
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TTButtonPreview() {
    TTButton(
        onClick = {},
        text = "Button"
    )
}

@Composable
@Preview(showBackground = true)
fun TTButtonWithStartIconPreview() {
    TTButton(
        onClick = {},
        text = "Button",
        startIcon = R.drawable.ic_launcher_background
    )
}

@Composable
@Preview(showBackground = true)
fun TTButtonWithEndIconPreview() {
    TTButton(
        onClick = {},
        text = "Button",
        endIcon = R.drawable.ic_launcher_background
    )
}