package com.example.spotifymockup.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(24.dp)
    ) {
        IconButton(onClick = onBack) {
            Icon(Icons.Filled.KeyboardArrowDown, contentDescription = "Tutup", tint = Color.White)
        }

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .background(song?.coverColor ?: Color.DarkGray, RoundedCornerShape(12.dp))
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            song?.title ?: "Tidak ada lagu",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White
        )
        Text(
            song?.artist ?: "-",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFFB3B3B3)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Slider(
            value = progress,
            onValueChange = onSeek,
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFF1DB954),
                activeTrackColor = Color(0xFF1DB954),
                inactiveTrackColor = Color(0xFF535353)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Filled.Shuffle, contentDescription = null, tint = Color(0xFFB3B3B3))
            IconButton(onClick = onPrevious) {
                Icon(Icons.Filled.SkipPrevious, contentDescription = "Sebelumnya", tint = Color.White, modifier = Modifier.size(36.dp))
            }
            IconButton(
                onClick = onTogglePlay,
                modifier = Modifier
                    .size(64.dp)
                    .background(Color.White, shape = CircleShape)
            ) {
                Icon(
                    imageVector = if (isPlaying) Icons.Filled.Pause else Icons.Filled.PlayArrow,
                    contentDescription = "Play/Pause",
                    tint = Color.Black,
                    modifier = Modifier.size(32.dp)
                )
            }
            IconButton(onClick = onNext) {
                Icon(Icons.Filled.SkipNext, contentDescription = "Berikutnya", tint = Color.White, modifier = Modifier.size(36.dp))
            }
            Icon(Icons.Filled.Repeat, contentDescription = null, tint = Color(0xFFB3B3B3))
        }
    }
}