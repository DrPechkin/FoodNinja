package ru.vedernikov.foodninja.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.vedernikov.foodninja.R
import ru.vedernikov.foodninja.extensions.coloredShadow
import ru.vedernikov.foodninja.ui.theme.FoodNinjaTheme

@ExperimentalAnimationApi
@Composable
fun HomeScreen(navController: NavController) {

    var hasNotification by remember {
        mutableStateOf(true)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_home),
            contentDescription = null,
            modifier = Modifier.align(Alignment.TopEnd)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
//Title
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 40.dp, top = 60.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = stringResource(id = R.string.label_home),
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 41.sp
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .background(
                            color = Color(0xFFFAFDFF),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .padding(14.dp)
                        .clickable { hasNotification = !hasNotification }
                        .coloredShadow(Color(0x33144E5A), shadowRadius = 50.dp)
                ) {
                    Image(
                        painter = painterResource(
                            id = if (hasNotification) R.drawable.ic_notifiaction_active
                            else R.drawable.ic_notifiaction
                        ),
                        contentDescription = null
                    )
                }
            }

//Search
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextField(
                    value = "",
                    singleLine = true,
                    onValueChange = {
                        /*TODO*/
                    },
                    modifier = Modifier
                        .height(50.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.secondary.copy(alpha = 0.1f),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.hint_search),
                            color = MaterialTheme.colors.secondary.copy(alpha = 0.4f),
                            modifier = Modifier.padding(start = 18.dp)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Search",
                            tint = MaterialTheme.colors.onSecondary,
                            modifier = Modifier.padding(start = 18.dp)
                        )
                    }
                )

                Spacer(modifier = Modifier.width(20.dp))

                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(
                                    MaterialTheme.colors.secondary,
                                    MaterialTheme.colors.secondary
                                )
                            ),
                            shape = RoundedCornerShape(15.dp),
                            alpha = 0.1f
                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_filter),
                        contentDescription = null
                    )
                }
            }

            Image(
                painter = painterResource(id = R.drawable.image_promo_advertising),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 25.dp, vertical = 10.dp),
                contentScale = ContentScale.FillWidth
            )

        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    FoodNinjaTheme {
        HomeScreen(NavController(LocalContext.current))
    }
}