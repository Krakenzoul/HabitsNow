package com.example.habitsnow.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.text.input.*
import androidx.navigation.NavHostController

import com.example.habitsnow.ui.theme.login.LoginScreen
import com.example.habitsnow.ui.theme.signup.SignUpScreen


object Routes {
    const val LOGIN = "login"
    const val SIGN_UP = "signup"
    const val HOME = "home"
    const val ADD_HABIT = "add_habit"
}
@Composable

fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ){
        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginSuccess = { navController.navigate(Routes.HOME) },
                onGoToSignUp = { navController.navigate(Routes.SIGN_UP) }
            )
        }
        composable(Routes.SIGN_UP) {
            SignUpScreen(
                onSignUpSuccess = { navController.navigate(Routes.HOME) },
                onGoToLogin = { navController.popBackStack(Routes.LOGIN, inclusive = false) }
            )
        }

}
}
