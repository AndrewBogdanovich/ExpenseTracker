package com.example.expensetracker.presentation.view.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.presentation.DevicesPreview

@Composable
fun ForgotPasswordView(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column() {
            Text(text = "Input you profile email", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(text = "We send reset link")
            OutlinedTextField(value = "", modifier = Modifier.fillMaxWidth(), onValueChange = {}, label = {
                Text(text = "enter email")
            })
        }

        Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(size = 6.dp)) {
            Text(text = "Send recovery code")
        }
    }
}

@DevicesPreview
@Composable
fun ForgotPasswordPreview() {
    val navController = rememberNavController()
    ForgotPasswordView(navController)
}