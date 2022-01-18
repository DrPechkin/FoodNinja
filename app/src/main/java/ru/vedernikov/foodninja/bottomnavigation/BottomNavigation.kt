package ru.vedernikov.foodninja.bottomnavigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.vedernikov.foodninja.BottomNavItem
import ru.vedernikov.foodninja.extensions.coloredShadow
import ru.vedernikov.foodninja.ui.theme.FoodNinjaTheme
import ru.vedernikov.foodninja.ui.theme.PrimaryShadowColor

@ExperimentalAnimationApi
@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Box(
        modifier = modifier
            .coloredShadow(
                color = PrimaryShadowColor,
                shadowRadius = 50.dp
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background, RoundedCornerShape(22.dp))
                .padding(horizontal = 20.dp, vertical = 15.dp)
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem.items.forEach { screen ->
                BottomNavigationItemButton(
                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                    title = stringResource(id = screen.title),
                    iconId = screen.icon,
                    onClick = {
                        navController.navigate(screen.route) {
                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    FoodNinjaTheme {
        BottomNavigation(navController = NavController(LocalContext.current))
    }
}