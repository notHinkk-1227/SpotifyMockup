package com.example.spotifymockup.navigation

sealed class Screen (val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object Search : Screen("search")
    object Library : Screen("library")
    object Profile : Screen("profile")
    object Player : Screen("player")
}