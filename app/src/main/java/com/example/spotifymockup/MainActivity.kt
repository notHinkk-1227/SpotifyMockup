package com.example.spotifymockup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.spotifymockup.navigation.SpotifyNavGraph
import com.example.spotifymockup.ui.theme.SpotifyMockupTheme
import com.example.spotifymockup.viewmodel.AuthViewModel
import com.example.spotifymockup.viewmodel.PlayerViewModel

class MainActivity : ComponentActivity() {

    private val authViewModel: AuthViewModel by viewModels()
    private val playerViewModel: PlayerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpotifyMockupTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    SpotifyNavGraph(
                        authViewModel = authViewModel,
                        playerViewModel = playerViewModel
                    )
                }
            }
        }
    }
}