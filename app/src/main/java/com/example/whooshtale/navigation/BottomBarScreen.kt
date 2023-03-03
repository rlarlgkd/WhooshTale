package com.example.whooshtale.navigation

import com.example.whooshtale.R

sealed class BottomBarScreen(
    val route: String,
    val title: Int,
    val icon: Int
) {
    object Whoosh : BottomBarScreen(
        route = "whoosh",
        title = R.string.navigation_whoosh,
        icon = R.drawable.ic_nav_wand
    )

    object Favorites : BottomBarScreen(
        route = "favorites",
        title = R.string.navigation_favorites,
        icon = R.drawable.ic_nav_favorites
    )

    object Library : BottomBarScreen(
        route = "library",
        title = R.string.navigation_library,
        icon = R.drawable.ic_nav_library
    )

    object Settings : BottomBarScreen(
        route = "settings",
        title = R.string.navigation_settings,
        icon = R.drawable.ic_nav_settings
    )
}