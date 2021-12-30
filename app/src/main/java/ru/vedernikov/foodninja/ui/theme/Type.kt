package ru.vedernikov.foodninja.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import ru.vedernikov.foodninja.R

val appFontFamily = FontFamily(
    Font(
        resId = R.font.bentonsans_bold,
        weight = FontWeight.Bold
    ),
    Font(
        resId = R.font.bentonsans_book,
        weight = FontWeight.Normal
    )
)

// Set of Material typography styles to start with
fun getTypography(isDark: Boolean, defaultTypography: Typography = Typography()): Typography {
    val primaryColor: Color
    val secondaryColor: Color
    if (isDark) {
        primaryColor = PrimaryTextColorDark
        secondaryColor = SecondaryTextColorDark
    } else {
        primaryColor = PrimaryTextColorLight
        secondaryColor = SecondaryTextColorLight
    }
    return Typography(
        h1 = defaultTypography.h1.copy(color = primaryColor, fontFamily = appFontFamily),
        h2 = defaultTypography.h2.copy(color = primaryColor, fontFamily = appFontFamily),
        h3 = defaultTypography.h3.copy(color = primaryColor, fontFamily = appFontFamily),
        h4 = defaultTypography.h4.copy(color = primaryColor, fontFamily = appFontFamily),
        h5 = defaultTypography.h5.copy(color = primaryColor, fontFamily = appFontFamily),
        h6 = defaultTypography.h6.copy(color = primaryColor, fontFamily = appFontFamily),
        subtitle1 = defaultTypography.subtitle1.copy(
            color = primaryColor,
            fontFamily = appFontFamily
        ),
        subtitle2 = defaultTypography.subtitle2.copy(
            color = secondaryColor,
            fontFamily = appFontFamily
        ),
        body1 = defaultTypography.body1.copy(color = primaryColor, fontFamily = appFontFamily),
        body2 = defaultTypography.body2.copy(color = secondaryColor, fontFamily = appFontFamily),
        button = defaultTypography.button.copy(color = primaryColor, fontFamily = appFontFamily),
        caption = defaultTypography.caption.copy(color = primaryColor, fontFamily = appFontFamily),
        overline = defaultTypography.overline.copy(
            color = primaryColor,
            fontFamily = appFontFamily
        ),
    )
}