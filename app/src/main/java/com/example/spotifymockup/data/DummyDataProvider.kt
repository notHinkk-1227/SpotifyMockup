package com.example.spotifymockup.data

import androidx.compose.ui.graphics.Color
import com.example.spotifymockup.model.Song

object DummyDataProvider {
    val songs = listOf(
        Song(1, "Starboy", "The Weeknd", "3:50", Color(0xFF7D3C98)),
        Song(2, "Don't Mind", "Kent Jones", "3:18", Color(0xFFC0392B)),
        Song(3, "Replay", " Iyaz", "3:02", Color(0xFF2980B9)),
        Song(4, "Fresh Eyes", " Andy Grammer", "3:18", Color(0xFF7D3C98)),
        Song(5, "I Like Me Better", " LAUV", "3:17", Color(0xFFC0392B))
    )
}