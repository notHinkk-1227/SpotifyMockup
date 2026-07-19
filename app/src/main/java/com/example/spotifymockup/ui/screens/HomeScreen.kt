package com.example.spotifymockup.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.spotifymockup.data.DummyDataProvider
import com.example.spotifymockup.model.Playlist
import com.example.spotifymockup.model.Song
import com.example.spotifymockup.ui.components.PlaylistCard
import com.example.spotifymockup.ui.components.SongListItem

@Composable
fun HomeScreen(
    onSongClick: (Song) -> Unit,
    onPlaylistClick: (Playlist) -> Unit,
    onProfileClick: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Selamat datang kembali",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                IconButton(onClick = onProfileClick) {
                    Icon(
                        Icons.Filled.AccountCircle,
                        contentDescription = "Profil",
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        }

        item {
            Text(
                "Baru diputar",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        items(DummyDataProvider.recentlyPlayed) { song ->
            SongListItem(song = song, onClick = onSongClick)
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Dibuat untuk kamu",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(DummyDataProvider.madeForYouPlaylists) { playlist ->
                    PlaylistCard(playlist = playlist, onClick = onPlaylistClick)
                }
            }
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}