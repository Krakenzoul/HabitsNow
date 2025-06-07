package com.example.habitsnow.ui.theme.signup

import androidx.lifecycle.ViewModel
import com.example.habitsnow.data.firebase.FirebaseAuthService
import com.google.firebase.auth.FirebaseUser
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class SignUpViewModel : ViewModel() {
    private val authService = FirebaseAuthService()

    var signUpSuccess by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var user: FirebaseUser? = null
        private set

    fun signUp(name:String,email: String, password: String) {
        authService.signUp(
            name = name,
            email = email,
            password = password,
            onSuccess = {
                user = it
                signUpSuccess = true
            },
            onFailure = {
                errorMessage = it
                signUpSuccess = false
            }
        )
    }

    fun clearError() {
        errorMessage = null
    }
}