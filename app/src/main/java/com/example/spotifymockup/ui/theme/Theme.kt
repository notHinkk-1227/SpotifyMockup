package com.example.spotifymockup.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val SpotifyColorScheme = darkColorScheme(
    primary = SpotifyGreen,
    onPrimary = Color.Black,
    secondary = SpotifyGreenDark,
    background = SpotifyBlack,
    onBackground = SpotifyWhite,
    surface = SpotifyDarkGray,
    onSurface = SpotifyWhite,
    surfaceVariant = SpotifyMediumGray,
    onSurfaceVariant = SpotifyLightGray
)

@Composable
fun SpotifyMockupTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = SpotifyColorScheme,
        typography = SpotifyTypography,
        content = content
    )
}