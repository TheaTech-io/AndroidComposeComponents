package com.theatech.composecomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private const val SDP_MAX = 600
private const val SDP_MIN = -60
private const val SSP_MAX = 100
private const val ZEPLIN_DESIGN_RATIO = 0.7333f

val Int.sdp: Dp
    @Composable
    get() = this.sdpGet()

val Int.ssp: TextUnit
    @Composable get() = sspGet()

@Composable
private fun Int.sdpGet(): Dp {
    val id = when (this) {
        in 1..SDP_MAX -> "_${this}sdp"
        in (SDP_MIN..-1) -> "_minus${this}sdp"
        else -> return this.dp
    }
    val resourceField = getFieldId(id)
    val sdpValue = if (resourceField != 0) dimensionResource(resourceField) else this.dp
    return Dp(sdpValue.value * ZEPLIN_DESIGN_RATIO)
}

@Composable
private fun Int.sspGet(): TextUnit {
    val id = when (this) {
        in 1..SSP_MAX -> "_${this}ssp"
        else -> return this.sp
    }
    val resourceField = getFieldId(id)
    val sspValue =
        if (resourceField != 0) {
            (dimensionResource(resourceField))
        } else {
            this.dp
        }
    return TextUnit(sspValue.value * ZEPLIN_DESIGN_RATIO, TextUnitType.Sp)
}

@Composable
private fun getFieldId(id: String): Int {
    val context = LocalContext.current
    return context.resources.getIdentifier(id, "dimen", context.packageName)
}