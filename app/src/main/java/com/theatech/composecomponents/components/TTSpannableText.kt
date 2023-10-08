package com.theatech.composecomponents.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.theatech.composecomponents.ssp

@Composable
fun PASpannableText(
    modifier: Modifier = Modifier,
    normalText: String,
    spanText: String,
    color: Color = Color.Black,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontWeight: FontWeight = FontWeight.Bold,
    lineHeight: TextUnit = 24.ssp
) {
    TTText(
        modifier = modifier,
        fontSize = fontSize,
        spannableText = buildAnnotatedString {
            withStyle(style = ParagraphStyle(lineHeight = lineHeight)) {
                val mStartIndex = normalText.indexOf(spanText)
                val mEndIndex = mStartIndex.plus(spanText.length)

                append(normalText)
                addStyle(
                    style = SpanStyle(
                        color = color,
                        fontWeight = fontWeight
                    ),
                    start = mStartIndex,
                    end = mEndIndex
                )
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun PASpannableTextPreview() {
    PASpannableText(
        normalText = "Spannable Text",
        spanText = "Text",
        color = Color.Red
    )
}