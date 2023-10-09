package com.theatech.composecomponents.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.theatech.composecomponents.R
import com.theatech.composecomponents.clickableWithoutRipple

@Composable
fun TTTextField(
    modifier: Modifier = Modifier,
    text: String,
    placeholder: String,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    startIcon: @Composable (() -> Unit)? = null,
    endIcon: Int? = null,
    endIconClick: (() -> Unit)? = null,
    onTextChange: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    val showPassword = rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        onValueChange = onTextChange,
        placeholder = { Text(placeholder) },
        singleLine = singleLine,
        maxLines = maxLines,
        leadingIcon = startIcon,
        trailingIcon = {
            if (keyboardType == KeyboardType.Password) {
                val icon = if (showPassword.value) R.drawable.ic_visibility_on else R.drawable.ic_visibility_off

                IconButton(onClick = { showPassword.value = !showPassword.value }) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = ""
                    )
                }
            } else {
                endIcon?.let {
                    Image(
                        modifier = Modifier.clickableWithoutRipple {
                            endIconClick?.invoke()
                        },
                        painter = painterResource(id = it),
                        contentDescription = null
                    )
                }
            }
        },
        shape = RoundedCornerShape(100),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.White,
        ),
        visualTransformation = if (showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default.copy(
            autoCorrect = true,
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = { endIconClick?.invoke() ?: focusManager.clearFocus() },
            onGo = { endIconClick?.invoke() ?: focusManager.clearFocus() },
            onSearch = { endIconClick?.invoke() ?: focusManager.clearFocus() },
            onSend = { endIconClick?.invoke() ?: focusManager.clearFocus() },
            onPrevious = { endIconClick?.invoke() ?: focusManager.clearFocus() },
            onNext = { endIconClick?.invoke() ?: focusManager.clearFocus() }
        ),
    )
}

@Composable
@Preview(showBackground = false)
fun TTTextFieldPreview() {
    var text by remember { mutableStateOf("") }
    TTTextField(
        text = text,
        placeholder = "Placeholder",
        keyboardType = KeyboardType.Number,
        onTextChange = {
            text = it
        },
        endIconClick = {
            text = ""
        }
    )
}

@Composable
@Preview(showBackground = false)
fun TTTextFieldWithStartIconPreview() {
    var text by remember { mutableStateOf("") }
    TTTextField(
        text = text,
        placeholder = "Email",
        keyboardType = KeyboardType.Email,
        startIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = null
            )
        },
        onTextChange = {
            text = it
        },
        endIconClick = {
            text = ""
        }
    )
}

@Composable
@Preview(showBackground = false)
fun TTTextFieldPasswordPreview() {
    var text by remember { mutableStateOf("") }
    TTTextField(
        text = text,
        placeholder = "Password",
        keyboardType = KeyboardType.Password,
        onTextChange = {
            text = it
        },
        endIconClick = {
            text = ""
        }
    )
}

@Composable
@Preview(showBackground = false)
fun TTTextFieldEndIconPreview() {
    var text by remember { mutableStateOf("") }
    TTTextField(
        text = text,
        placeholder = "Placeholder",
        endIcon = R.drawable.ic_clear,
        onTextChange = {
            text = it
        },
        endIconClick = {
            text = ""
        }
    )
}