package com.theatech.composecomponents.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import com.theatech.composecomponents.clickableWithoutRipple
import com.theatech.composecomponents.sdp

@Composable
fun TTTextField(
    text: String,
    placeholder: String,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    startIcon: Int? = null,
    endIcon: Int? = null,
    endIconClick: () -> Unit = {},
    onTextChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.padding(12.sdp),
        value = text,
        onValueChange = onTextChange,
        placeholder = { Text(placeholder) },
        singleLine = singleLine,
        maxLines = maxLines,
        leadingIcon = {
            startIcon?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = null
                )
            }
        },
        trailingIcon = {
            endIcon?.let {
                Image(
                    modifier = Modifier.clickableWithoutRipple { endIconClick() },
                    painter = painterResource(id = it),
                    contentDescription = null
                )
            }
        },
        shape = RoundedCornerShape(100),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color.DarkGray,
            focusedContainerColor = Color.DarkGray,
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.White,
        )
    )
}

@Composable
@Preview(showBackground = false)
fun TTTextFieldPreview() {
    var text by remember { mutableStateOf("") }
    TTTextField(
        text = text,
        placeholder = "Placeholder",
        startIcon = android.R.drawable.ic_menu_search,
        endIcon = android.R.drawable.ic_menu_search,
        onTextChange = {
            text = it
        }
    )
}