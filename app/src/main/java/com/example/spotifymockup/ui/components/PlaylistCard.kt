package com.example.spotifymockup.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spotifymockup.data.DummyDataProvider.songs
import com.example.spotifymockup.model.Playlist
import com.example.spotifymockup.ui.theme.SpotifyMockupTheme

@Composable
fun PlaylistCard(playlist: Playlist, onClick: (Playlist) -> Unit) {
    Column(
        modifier = Modifier
            .width(140.dp)
            .clickable { onClick(playlist) }
    ) {
        Box(
            modifier = Modifier
                .size(140.dp)
                .background(playlist.coverColor, RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Filled.MusicNote,
                contentDescription = null,
                tint = Color.White.copy(alpha = 0.85f),
                modifier = Modifier.size(48.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            playlist.title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            playlist.description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun PlaylistCardPreview() {
    SpotifyMockupTheme{
        PlaylistCard(
            playlist = Playlist(1, "Daily Mix 1", "Dibuat khusus untuk kamu", Color(0xFF8E44AD), songs.take(4)),
            onClick = {}
        )
    }
}
