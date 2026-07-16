package com.example.spotifymockup.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.spotifymockup.navigation.Screen

data class BottomNavItem(val screen: Screen, val label: String, val icon: ImageVector)

val bottomNavItems = listOf(
    BottomNavItem(Screen.Home, "Home", Icons.Filled.Home),
    BottomNavItem(Screen.Search, "Search", Icons.Filled.Search),
    BottomNavItem(Screen.Library, "Library", Icons.Filled.LibraryMusic)
)

@Composable
fun SpotifyBottomNavBar(currentRoute: String?, onItemClick: (Screen) -> Unit) {
    NavigationBar(containerColor = Color(0xFF181818)) {
        bottomNavItems.forEach { item ->
            val selected = currentRoute == item.screen.route
            NavigationBarItem(
                selected = selected,
                onClick = { onItemClick(item.screen) },
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF1DB954),
                    selectedTextColor = Color(0xFF1DB954),
                    unselectedIconColor = Color(0xFFB3B3B3),
                    unselectedTextColor = Color(0xFFB3B3B3),
                    indicatorColor = Color(0xFF282828)
                )
            )
        }
    }
}