package com.example.whooshtale.ui.screens.favorites.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.whooshtale.R
import com.example.whooshtale.ui.common.CustomTopAppBar

@Composable
fun FavoritesScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        CustomTopAppBar(
            headerText = stringResource(R.string.favorites_header),
            icon = R.drawable.ic_nav_favorites
        )
    }
}