package com.example.spotifymockup.model

import androidx.compose.ui.graphics.Color

data class Playlist(
    val id: Int,
    val title: String,
    val description: String,
    val coverColor: Color,
    val songs: List<Song> = emptyList()
)