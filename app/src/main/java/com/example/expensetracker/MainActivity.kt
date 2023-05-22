package com.example.expensetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SigInView()
                }
            }
        }
    }
}

@Composable
fun SigInView() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Login", fontSize = 32.sp
        )
        OutlinedTextField(
            value = "",
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_account_circle_24),
                    contentDescription = "email icon"
                )
            },
            onValueChange = {},
            label = { Text(text = "Email address") },
            placeholder = { Text(text = "Enter you e-mail") }
        )
        OutlinedTextField(
            value = "",
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_vpn_key_24),
                    contentDescription = "password icon"
                )
            },
            onValueChange = {},
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Enter you password") }
        )
        Row() {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = true, onClick = { /*TODO*/ })
                Text(text = "Remember me", modifier = Modifier.padding(end = 10.dp))
            }
            Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(size = 6.dp)) {
                Text(text = "Login")
                Icon(
                    painter = painterResource(id = R.drawable.baseline_login_24),
                    contentDescription = "sign in icon",
                    modifier = Modifier.padding(start = 6.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignInPreview() {
    SigInView()
}


