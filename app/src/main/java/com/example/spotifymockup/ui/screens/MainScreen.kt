package com.example.spotifymockup.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.spotifymockup.model.Playlist
import com.example.spotifymockup.model.Song
import com.example.spotifymockup.navigation.Screen
import com.example.spotifymockup.ui.components.MiniPlayer
import com.example.spotifymockup.ui.components.SpotifyBottomNavBar

@Composable
fun MainScreen(
    currentSong: Song?,
    isPlaying: Boolean,
    onTogglePlay: () -> Unit,
    onSongSelected: (Song) -> Unit,
    onPlaylistSelected: (Playlist) -> Unit,
    onOpenPlayer: () -> Unit,
    onOpenProfile: () -> Unit
) {
    val innerNavController: NavHostController = rememberNavController()
    val backStackEntry by innerNavController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            Column {
                currentSong?.let {
                    MiniPlayer(
                        song = it,
                        isPlaying = isPlaying,
                        onTogglePlay = onTogglePlay,
                        onClick = onOpenPlayer
                    )
                }
                SpotifyBottomNavBar(currentRoute = currentRoute) { screen ->
                    innerNavController.navigate(screen.route) {
                        popUpTo(Screen.Home.route) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = innerNavController,
                startDestination = Screen.Home.route,
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(Screen.Home.route) {
                    HomeScreen(
                        onSongClick = onSongSelected,
                        onPlaylistClick = onPlaylistSelected,
                        onProfileClick = onOpenProfile
                    )
                }
                composable(Screen.Search.route) {
                    SearchScreen()
                }
                composable(Screen.Library.route) {
                    LibraryScreen(onPlaylistClick = onPlaylistSelected)
                }
            }
        }
    }
}