package com.theatech.composecomponents.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.theatech.composecomponents.R
import com.theatech.composecomponents.sdp

@Composable
fun TTOutlinedButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    startIcon: Int? = null,
    endIcon: Int? = null,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.shape,
    colors: ButtonColors = ButtonDefaults.buttonColors()
) {
    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        colors = colors,
        modifier = modifier
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
            Text(text = text)
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
fun TTOutlinedButton() {
    TTOutlinedButton(
        onClick = {},
        text = "Button",
        startIcon = R.drawable.ic_launcher_background,
        endIcon = R.drawable.ic_launcher_background
    )
}

@Composable
@Preview(showBackground = true)
fun TTOutlinedButtonWithStartIconPreview() {
    TTOutlinedButton(
        onClick = {},
        text = "Button",
        startIcon = R.drawable.ic_launcher_background
    )
}

@Composable
@Preview(showBackground = true)
fun TTOutlinedButtonWithEndIconPreview() {
    TTOutlinedButton(
        onClick = {},
        text = "Button",
        endIcon = R.drawable.ic_launcher_background
    )
}