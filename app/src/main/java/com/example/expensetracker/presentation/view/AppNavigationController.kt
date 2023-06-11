package com.example.expensetracker.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.presentation.view.achivement.AchievementListView
import com.example.expensetracker.presentation.view.login.ForgotPasswordView
import com.example.expensetracker.presentation.view.login.SigInView
import com.example.expensetracker.presentation.view.login.SignUpView

@Composable
fun StartupNavigationView() {
    val navController = rememberNavController()
    NavHost(
        modifier = Modifier.fillMaxSize(),
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
        composable("achievementsListView"){
            AchievementListView(navController)
        }
    }
}