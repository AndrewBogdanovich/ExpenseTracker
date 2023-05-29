package com.example.expensetracker.view.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.DevicesPreview
import com.example.expensetracker.R

@Composable
fun SigInView(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
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
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(selected = true, onClick = { /*TODO*/ })
            Text(text = "Remember me", modifier = Modifier.padding(end = 10.dp))
            Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(size = 6.dp)) {
                Text(text = "Login")
                Icon(
                    painter = painterResource(id = R.drawable.baseline_login_24),
                    contentDescription = "sign in icon",
                    modifier = Modifier.padding(start = 6.dp)
                )
            }
        }

        Row(modifier = Modifier.padding(10.dp)) {
            val forgot =
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("forgot password")
                    }
                }
            val signUp = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append("/ sign up")
                }
            }
            ClickableText(
                text = forgot,
                modifier = Modifier.padding(0.dp, 0.dp, 5.dp, 0.dp),
                onClick = {
                    navController.navigate("forgotPasswordView")
                })
            ClickableText(
                text = signUp,
                onClick = {
                    navController.navigate("signUpView")
                })
        }
    }
}

@DevicesPreview
@Composable
fun SignInPreview() {
    val navController = rememberNavController()
    SigInView(navController)
}