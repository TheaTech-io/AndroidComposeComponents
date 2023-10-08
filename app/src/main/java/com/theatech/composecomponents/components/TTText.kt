package com.theatech.composecomponents.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.theatech.composecomponents.ssp

@Composable
fun TTText(
    modifier: Modifier = Modifier,
    text: String? = null,
    spannableText: AnnotatedString? = null,
    textDecoration: TextDecoration? = null,
    style: TextStyle = MaterialTheme.typography.bodySmall,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    align: TextAlign = TextAlign.Start,
    fontWeight: FontWeight? = null,
    fontSize: TextUnit = TextUnit.Unspecified,
    lineHeight: TextUnit = TextUnit.Unspecified,
    color: Color = Color.Black
) {
    if (spannableText != null) {
        Text(
            modifier = modifier,
            text = spannableText,
            textDecoration = textDecoration,
            style = style,
            maxLines = maxLines,
            overflow = overflow,
            fontSize = fontSize,
            fontWeight = fontWeight,
            lineHeight = lineHeight,
            color = color,
            textAlign = align
        )
    } else {
        Text(
            modifier = modifier,
            text = text.orEmpty(),
            textDecoration = textDecoration,
            style = style,
            maxLines = maxLines,
            overflow = overflow,
            fontSize = fontSize,
            fontWeight = fontWeight,
            lineHeight = lineHeight,
            color = color,
            textAlign = align
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TTTextPreview() {
    TTText(
        text = "Text\nText2"
    )
}