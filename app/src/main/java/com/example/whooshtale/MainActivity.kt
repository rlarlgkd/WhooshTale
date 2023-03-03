package com.example.whooshtale

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.whooshtale.others.NetworkObserver
import com.example.whooshtale.ui.screens.other.MainScreen
import com.example.whooshtale.ui.screens.settings.viewmodels.SettingsViewModel
import com.example.whooshtale.ui.screens.settings.viewmodels.ThemeMode
import com.example.whooshtale.ui.theme.WhooshTaleTheme

@ExperimentalMaterial3Api
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {

    private lateinit var networkObserver: NetworkObserver
    lateinit var settingsViewModel: SettingsViewModel

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        networkObserver = NetworkObserver(applicationContext)
        settingsViewModel = ViewModelProvider(this)[SettingsViewModel::class.java]

        setContent {
            WhooshTaleTheme(settingsViewModel = settingsViewModel) {
                val status by networkObserver.observe().collectAsState(
                    initial = NetworkObserver.Status.Unavailable
                )
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(status, settingsViewModel = settingsViewModel)
                }
            }
        }
    }
}
