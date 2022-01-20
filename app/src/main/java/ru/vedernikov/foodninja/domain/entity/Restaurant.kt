package ru.vedernikov.foodninja.domain.entity

import androidx.annotation.DrawableRes
import ru.vedernikov.foodninja.R

data class Restaurant(
    val name: String,
    @DrawableRes
    val image: Int,
    val distanceInMinutesStr: String
) {
    companion object {
        val getList = listOf(
            Restaurant(
                name = "Vegan Resto",
                image = R.drawable.image_vegan_resto,
                distanceInMinutesStr = "12 Mins"
            ),
            Restaurant(
                name = "Healthy",
                image = R.drawable.image_healthy_resto,
                distanceInMinutesStr = "8 Mins"
            ),
            Restaurant(
                name = "Good Food",
                image = R.drawable.image_good_food_resto,
                distanceInMinutesStr = "12 Mins"
            )
        )
    }
}