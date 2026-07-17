package com.example.spotifymockup.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.spotifymockup.model.Song

class PlayerViewModel : ViewModel() {

    var currentSong by mutableStateOf<Song?>(null)
        private set

    var isPlaying by mutableStateOf(false)
        private set

    var progress by mutableStateOf(0.3f)
        private set

    fun play(song: Song) {
        currentSong = song
        isPlaying = true
        progress = 0f
    }

    fun togglePlayPause() {
        if (currentSong != null) {
            isPlaying = !isPlaying
        }
    }

    fun seekTo(value: Float) {
        progress = value
    }

    fun next() {
        progress = 0f
    }

    fun previous() {
        progress = 0f
    }
}