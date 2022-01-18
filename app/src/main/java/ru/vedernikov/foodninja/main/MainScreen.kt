package ru.vedernikov.foodninja.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.vedernikov.foodninja.BottomNavItem
import ru.vedernikov.foodninja.bottomnavigation.BottomNavigation
import ru.vedernikov.foodninja.cart.CartScreen
import ru.vedernikov.foodninja.chat.ChatScreen
import ru.vedernikov.foodninja.home.HomeScreen
import ru.vedernikov.foodninja.profile.ProfileScreen
import ru.vedernikov.foodninja.ui.theme.FoodNinjaTheme

@ExperimentalAnimationApi
@Preview
@Composable
fun MainScreenPreview() {
    FoodNinjaTheme {
        MainScreen()
    }
}

@ExperimentalAnimationApi
@Composable
fun MainScreen() {

    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.padding(10.dp),
                navController = navController
            )
        }
    )
    { innerPadding ->
        NavigationGraph(navController = navController, innerPadding = innerPadding)
    }
}

@ExperimentalAnimationApi
@Composable
fun NavigationGraph(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController,
        startDestination = BottomNavItem.Home.route,
        Modifier.padding(innerPadding)
    ) {
        composable(BottomNavItem.Home.route) {
            HomeScreen(navController)
        }
        composable(BottomNavItem.Profile.route) {
            ProfileScreen(navController)
        }
        composable(BottomNavItem.Cart.route) {
            CartScreen(navController)
        }
        composable(BottomNavItem.Chat.route) {
            ChatScreen(navController)
        }
    }
}