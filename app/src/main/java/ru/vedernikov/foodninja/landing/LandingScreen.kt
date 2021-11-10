package ru.vedernikov.foodninja.landing

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import ru.vedernikov.foodninja.R
import ru.vedernikov.foodninja.ui.theme.FoodNinjaTheme

const val SplashWaitTime = 1000L

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun DefaultPreview() {
    FoodNinjaTheme {
        LandingScreen(onTimeout = {})
    }
}

@Composable
fun LandingScreen(
    modifier: Modifier = Modifier,
    onTimeout: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {

        // This will always refer to the latest onTimeout function that
        // LandingScreen was recomposed with
        val currentOnTimeout by rememberUpdatedState(onTimeout)

        // Create an effect that matches the lifecycle of LandingScreen.
        // If LandingScreen recomposes or onTimeout changes,
        // the delay shouldn't start again.
        LaunchedEffect(true) {
            delay(SplashWaitTime)
            currentOnTimeout()
        }

        Image(
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = R.drawable.bg_landing),
            contentDescription = null
        )
        Image(
            modifier = modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = R.drawable.bg_landing_gradient),
            contentDescription = null
        )
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.ic_app_name),
            contentDescription = null
        )
    }
}