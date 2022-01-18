package ru.vedernikov.foodninja.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = PrimaryColor,
    primaryVariant = Color.Transparent,
    secondary = SecondaryColor,
    background = BlackBg,
    surface = BlackBg,
    onPrimary = Color.Black,
    onSecondary = OnSecondaryColor,
    onBackground = Color.White,
    onSurface = Color.White,
)

private val LightColorPalette = lightColors(
    primary = PrimaryColor,
    primaryVariant = Color.Transparent,
    secondary = SecondaryColor,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = OnSecondaryColor,
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun FoodNinjaTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val typography = getTypography(darkTheme)

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}