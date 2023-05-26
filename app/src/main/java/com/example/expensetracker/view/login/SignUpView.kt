package com.example.expensetracker.view.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.expensetracker.R

@Composable
fun SignUpView(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Sign Up", fontSize = 32.sp)
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "user name")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_account_circle_24),
                    contentDescription = ""
                )
            })
        OutlinedTextField(value = "", onValueChange = {}, label = {
            Text(text = "password")
        },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_vpn_key_24),
                    contentDescription = ""
                )
            })
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "confirm password")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_vpn_key_24),
                    contentDescription = ""
                )
            })
        OutlinedTextField(value = "", onValueChange = {}, label = {
            Text(text = "email")
        }, leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_mail_24),
                contentDescription = ""
            )
        })
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(size = 6.dp)
        ) {
            Text(text = "Sign up")
        }
    }
}