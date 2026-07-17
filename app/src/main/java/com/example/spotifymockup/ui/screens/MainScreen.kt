package com.example.spotifymockup.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.spotifymockup.model.Playlist
import com.example.spotifymockup.model.Song

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

}