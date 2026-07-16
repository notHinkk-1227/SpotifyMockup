package com.example.spotifymockup.model

import androidx.compose.ui.graphics.Color

data class Song(
    val id: Int,
    val title: String,
    val artist: String,
    val duration: String,
    val coverColor: Color
)