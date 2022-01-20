package ru.vedernikov.foodninja.bottomnavigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.vedernikov.foodninja.R

sealed class BottomNavItem(
    @StringRes
    val title: Int,
    @DrawableRes
    val icon: Int,
    val route: String
) {

    object Home : BottomNavItem(
        R.string.label_bottom_bar_home,
        R.drawable.ic_bottom_home_active,
        "home"
    )

    object Profile : BottomNavItem(
        R.string.label_bottom_bar_profile,
        R.drawable.ic_bottom_profile_active,
        "profile"
    )

    object Cart : BottomNavItem(
        R.string.label_bottom_bar_cart,
        R.drawable.ic_bottom_buy_active,
        "cart"
    )

    object Chat : BottomNavItem(
        R.string.label_bottom_bar_chat,
        R.drawable.ic_bottom_chat_active,
        "chat"
    )

    companion object {
        val items = listOf(
            Home,
            Profile,
            Cart,
            Chat
        )
    }
}