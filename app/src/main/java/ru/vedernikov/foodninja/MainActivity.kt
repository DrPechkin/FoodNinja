package ru.vedernikov.foodninja

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ru.vedernikov.foodninja.home.HomeScreen
import ru.vedernikov.foodninja.landing.LandingScreen
import ru.vedernikov.foodninja.main.MainScreen
import ru.vedernikov.foodninja.onboarding.OnboardScreen
import ru.vedernikov.foodninja.ui.theme.FoodNinjaTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodNinjaTheme() {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.DarkGray) {
//                    OnboardScreen(
//                        title = "Find your Comfort\nFood here",
//                        description = "Here You Can find a chef or dish for every\ntaste and color. Enjoy!"
//                    ) {
//
//                    }
                    MainScreen()
                }
            }
        }
    }
}