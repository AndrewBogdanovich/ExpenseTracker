package com.example.expensetracker.view.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.DevicesPreview

@Composable
fun ForgotPasswordView(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Forgot password", fontSize = 32.sp)
        OutlinedTextField(value = "", onValueChange = {}, label = {
            Text(text = "enter email")
        })
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