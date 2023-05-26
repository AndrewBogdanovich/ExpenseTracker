package com.example.expensetracker.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.view.login.ForgotPasswordView
import com.example.expensetracker.view.login.SigInView
import com.example.expensetracker.view.login.SignUpView

@Composable
fun StartupNavigationView() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "signInView"
    ) {
        composable("signInView") {
            SigInView(navController)
        }
        composable("signUpView") {
            SignUpView(navController)
        }
        composable("forgotPasswordView") {
            ForgotPasswordView(navController)
        }
    }
}