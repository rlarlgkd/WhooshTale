package com.example.whooshtale.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.whooshtale.others.NetworkObserver
import com.example.whooshtale.ui.screens.favorites.composables.FavoritesScreen
import com.example.whooshtale.ui.screens.library.composables.LibraryScreen
import com.example.whooshtale.ui.screens.settings.composables.SettingsScreen
import com.example.whooshtale.ui.screens.whoosh.composables.WhooshScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
@ExperimentalMaterial3Api
@ExperimentalComposeUiApi
@Composable
fun NavGraph(
    navController: NavHostController,
    networkStatus: NetworkObserver.Status,
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = BottomBarScreen.Whoosh.route,
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) {

        /** Home Screen */
        /** Home Screen */
        composable(
            route = BottomBarScreen.Whoosh.route,

        ) {
            WhooshScreen(navController, networkStatus)
        }
        composable(
            route = BottomBarScreen.Favorites.route,

            ) {
            FavoritesScreen(navController)
        }
        composable(
            route = BottomBarScreen.Library.route,
        ){
            LibraryScreen(navController)
        }
        composable(
            route = BottomBarScreen.Settings.route,
        ){
            SettingsScreen(navController = navController)
        }


    }
}