package com.example.habitsnow.ui.theme.login

import androidx.lifecycle.ViewModel
import com.example.habitsnow.data.firebase.FirebaseAuthService
import com.google.firebase.auth.FirebaseUser
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class LoginViewModel(
    private val authService: FirebaseAuthService = FirebaseAuthService()
) : ViewModel() {

    var loginSuccess by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var user: FirebaseUser? = null
        private set

    fun login(email: String, password: String) {
        authService.login(
            email = email,
            password = password,
            onSuccess = { firebaseUser ->
                user = firebaseUser
                loginSuccess = true
            },
            onFailure = { error ->
                errorMessage = error
                loginSuccess = false
            }
        )
    }
}