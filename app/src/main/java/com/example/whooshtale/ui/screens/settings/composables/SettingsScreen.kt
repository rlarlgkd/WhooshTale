package com.example.whooshtale.ui.screens.settings.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.whooshtale.R
import com.example.whooshtale.ui.common.CustomTopAppBar

@Composable
fun SettingsScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        CustomTopAppBar(
            headerText = stringResource(R.string.settings_header),
            icon = R.drawable.ic_nav_settings
        )
    }
}