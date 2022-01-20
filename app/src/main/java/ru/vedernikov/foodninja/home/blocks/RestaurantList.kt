package ru.vedernikov.foodninja.home.blocks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.vedernikov.foodninja.R
import ru.vedernikov.foodninja.domain.entity.Restaurant
import ru.vedernikov.foodninja.extensions.coloredShadow
import ru.vedernikov.foodninja.ui.theme.AccentTextColor
import ru.vedernikov.foodninja.ui.theme.FoodNinjaTheme
import ru.vedernikov.foodninja.ui.theme.PrimaryShadowColor

@Preview(showBackground = true)
@Composable
fun BlockWithHorizontalItemsPrev() {
    FoodNinjaTheme {
        RestaurantList(
            items = Restaurant.getList
        )
    }
}

@Composable
fun RestaurantList(
    title: String = "Nearest Restaurant",
    items: List<Restaurant>,
    viewMoreVisible: Boolean = true,
    onViewMoreClick: () -> Unit = {},
    onOnItemClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 31.dp, end = 31.dp, top = 25.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold
            )
            if (viewMoreVisible) {
                Text(
                    text = stringResource(id = R.string.btn_view_more),
                    color = AccentTextColor,
                    modifier = Modifier.clickable(onClick = onViewMoreClick)
                )
            }
        }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            contentPadding = PaddingValues(horizontal = 25.dp, vertical = 18.dp)
        ) {
            items(items) { resto ->
                RestaurantListItem(restaurant = resto)
            }
        }
    }
}

@Composable
fun RestaurantListItem(restaurant: Restaurant) {
    Box(
        modifier = Modifier
            .size(width = 147.dp, height = 184.dp)
            .coloredShadow(
                color = PrimaryShadowColor.copy(alpha = 0.07f),
                shadowRadius = 50.dp
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(22.dp)
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = restaurant.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(74.dp)
                    .weight(1f)
                    .padding(start = 25.dp, end = 25.dp, top = 25.dp),
            )
            Text(
                text = restaurant.name,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
            )
            Text(
                text = restaurant.distanceInMinutesStr,
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 25.dp)
            )
        }
    }
}