package com.example.spotifymockup.data

import androidx.compose.ui.graphics.Color
import com.example.spotifymockup.model.Artist
import com.example.spotifymockup.model.Playlist
import com.example.spotifymockup.model.Song

object DummyDataProvider {
    val songs = listOf(
        Song(1, "Starboy", "The Weeknd", "3:50", Color(0xFF7D3C98)),
        Song(2, "Don't Mind", "Kent Jones", "3:18", Color(0xFFC0392B)),
        Song(3, "Replay", "Iyaz", "3:02", Color(0xFF2980B9)),
        Song(4, "Fresh Eyes", "Andy Grammer", "3:18", Color(0xFF7D3C98)),
        Song(5, "I Like Me Better", "LAUV", "3:17", Color(0xFFC0392B)),
        Song(6, "Stay", "The Kid LAROI", "2:21", Color(0xFF6C3483)),
        Song(7, "Bad Habit", "Steve Lacy", "3:52", Color(0xFF922B21)),
        Song(8, "Flowers", "Miley Cyrus", "3:20", Color(0xFF1A5276))
    )

    val recentlyPlayed = songs.shuffled().take(8)

    val madeForYouPlaylists = listOf(
        Playlist(1, "Daily Mix 1", "Dibuat khusus untuk kamu", Color(0xFF8E44AD), songs.take(4)),
        Playlist(2, "Discover Weekly", "Lagu baru setiap minggu", Color(0xFF16A085), songs.takeLast(4)),
        Playlist(3, "Release Radar", "Rilisan terbaru favoritmu", Color(0xFFD35400), songs.shuffled().take(5)),
        Playlist(4, "On Repeat", "Lagu yang sering kamu putar", Color(0xFF2E86C1), songs.shuffled().take(3))
    )

    val libraryPlaylists = listOf(
        Playlist(5, "Liked Songs", "247 Lagu", Color(0xFF6C3483), songs),
        Playlist(6, "Chill Vibes", "42 lagu", Color(0xFF117864), songs.shuffled().take(6)),
        Playlist(7, "Workout Mix", "30 lagu", Color(0xFFC0392B), songs.shuffled().take(5)),
        Playlist(8, "Road Trip", "58 lagu", Color(0xFFD68910), songs.shuffled().take(7))
    )

    val topArtists = listOf(
        Artist(1, "The Weeknd", "94.3jt pendengar", Color(0xFF922B21)),
        Artist(2, "Dua Lipa", "68.1jt pendengar", Color(0xFF2980B9)),
        Artist(3, "Harry Styles", "55.7jt pendengar", Color(0xFF117864)),
        Artist(4, "Miley Cyrus", "40.2jt pendengar", Color(0xFF6C3483))
    )

    val genres = listOf(
        "Pop" to Color(0xFF8E44AD),
        "Hip-Hop" to Color(0xFFD35400),
        "Rock" to Color(0xFFC0392B),
        "Indie" to Color(0xFF16A085),
        "Dangdut" to Color(0xFF2980B9),
        "Jazz" to Color(0xFF6C3483),
        "EDM" to Color(0xFF117864),
        "K-Pop" to Color(0xFFD68910)
    )
}