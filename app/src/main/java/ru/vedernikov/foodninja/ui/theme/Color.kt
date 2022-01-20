package ru.vedernikov.foodninja.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val StartPrimaryGradientColor = Color(0xff53E88B)
val EndPrimaryGradientColor = Color(0xff15BE77)

val PrimaryColorGradient = Brush.horizontalGradient(
    listOf(
        StartPrimaryGradientColor,
        EndPrimaryGradientColor
    )
)

val PrimaryColor = Color(0xff53E88B)
val SecondaryColor = Color(0xffF9A84D)
val OnSecondaryColor = Color(0xffDA6317)

val BlackBg = Color(0xFF0D0D0D)

val PrimaryShadowColor = Color(0x1A5A6CEA)

val PrimaryTextColorDark = Color(0xffffffff)
val SecondaryTextColorDark = Color(0xffffffff)
val PrimaryTextColorLight = Color(0xFF09051C)
val SecondaryTextColorLight = Color(0xFF000000)

val AccentTextColor = Color(0xFFFF7C32)

val ScreenBackground = Color(0xFFFEFEFF)

@Composable
fun getPrimaryTextColor(): Color {
    return if (isSystemInDarkTheme()) {
        PrimaryTextColorDark
    } else {
        PrimaryTextColorLight
    }
}

@Composable
fun getSecondaryTextColor(): Color {
    return if (isSystemInDarkTheme()) {
        SecondaryTextColorDark
    } else {
        SecondaryTextColorLight
    }
}