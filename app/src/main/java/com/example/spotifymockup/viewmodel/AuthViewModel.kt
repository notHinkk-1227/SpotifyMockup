package com.example.spotifymockup.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.spotifymockup.model.User

class AuthViewModel : ViewModel() {

    var currentUser by mutableStateOf<User?>(null)
        private set

    fun login(email: String, password: String): Boolean {
        if (email.isNotBlank() && password.isNotBlank()) {
            val username = email.substringBefore("@").ifBlank { "User" }
            currentUser = User(username = username, email = email)
            return true
        }
        return false
    }

    fun logout() {
        currentUser = null
    }
}