package com.example.spotifymockup.model

data class User(
    val username: String,
    val email: String,
    val avatarInitial: String = username.firstOrNull()?.uppercaseChar()?.toString() ?: "?"
)