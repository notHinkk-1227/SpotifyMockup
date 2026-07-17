package com.example.spotifymockup.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spotifymockup.ui.screens.LoginScreen
import com.example.spotifymockup.ui.screens.MainScreen
import com.example.spotifymockup.ui.screens.PlayerScreen
import com.example.spotifymockup.ui.screens.ProfileScreen
import com.example.spotifymockup.viewmodel.AuthViewModel
import com.example.spotifymockup.viewmodel.PlayerViewModel

@Composable
fun SpotifyNavGraph(
    authViewModel: AuthViewModel,
    playerViewModel: PlayerViewModel
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = { email, password -> authViewModel.login(email, password) },
                onLoginClick = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Home.route) {
            MainScreen(
                currentSong = playerViewModel.currentSong,
                isPlaying = playerViewModel.isPlaying,
                onTogglePlay = { playerViewModel.togglePlayPause() },
                onSongSelected = { song ->
                    playerViewModel.play(song)
                    navController.navigate(Screen.Player.route)
                },
                onPlaylistSelected = { playlist ->
                    playlist.songs.firstOrNull()?.let {
                        playerViewModel.play(it)
                        navController.navigate(Screen.Player.route)
                    }
                },
                onOpenPlayer = { navController.navigate(Screen.Player.route) },
                onOpenProfile = { navController.navigate(Screen.Profile.route) }
            )
        }

        composable(Screen.Player.route) {
            PlayerScreen(
                song = playerViewModel.currentSong,
                isPlaying = playerViewModel.isPlaying,
                progress = playerViewModel.progress,
                onTogglePlay = { playerViewModel.togglePlayPause() },
                onNext = { playerViewModel.next() },
                onPrevious = { playerViewModel.previous() },
                onSeek = { playerViewModel.seekTo(it) },
                onBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Profile.route) {
            ProfileScreen(
                user = authViewModel.currentUser,
                onLogout = {
                    authViewModel.logout()
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}