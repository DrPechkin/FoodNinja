package ru.vedernikov.foodninja.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val BlackBg = Color(0xFF0D0D0D)


val PrimaryTextColorDark = Color(0xffffffff)
val SecondaryTextColorDark = Color(0xffffffff)
val PrimaryTextColorLight = Color(0xFF09051C)
val SecondaryTextColorLight = Color(0xFF000000)

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