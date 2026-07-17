package com.example.spotifymockup.ui.screens

import androidx.compose.runtime.Composable
import com.example.spotifymockup.model.Song

@Composable
fun PlayerScreen(
    song: Song?,
    isPlaying: Boolean,
    progress: Float,
    onTogglePlay: () -> Unit,
    onNext: () -> Unit,
    onPrevious: () -> Unit,
    onSeek: (Float) -> Unit,
    onBack: () -> Unit
) {

}