package com.example.expensetracker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onStart() {
        super.onStart()
        auth = Firebase.auth
        firebaseAuthSignIn()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SigInView()
//                    SignUpView()
                }
            }
        }
    }

    private fun firebaseAuthSignIn() {
        auth.signInWithEmailAndPassword("andrewbohdanovich@gmail.com", "mdq7a5wrjp")
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val token = auth.currentUser?.uid
                } else {
                    Toast.makeText(this, "Auth failed", Toast.LENGTH_LONG).show()
                }
            }
    }
}

@Composable
fun SigInView() {
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        // Handle the result here if needed
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
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
        val text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)) {
                append("or sign up")
                addStringAnnotation("URL", "https://google.com", start = 0, end = length)
            }
        }
        ClickableText(
            text = text,
            onClick = { offset ->
                text.getStringAnnotations("URL", offset, offset).firstOrNull()?.let { annotation ->
                    val url = annotation.item
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    launcher.launch(intent)
                }
            })
    }
}

@Composable
fun SignUpView() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Sign Up", fontSize = 32.sp)
        OutlinedTextField(value = "", onValueChange = {}, label = {
            Text(text = "user name")
        })
        OutlinedTextField(value = "", onValueChange = {}, label = {
            Text(text = "password")
        })
        OutlinedTextField(value = "", onValueChange = {}, label = {
            Text(text = "confirm password")
        })
        OutlinedTextField(value = "", onValueChange = {}, label = {
            Text(text = "email")
        })
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(size = 6.dp)
        ) {
            Text(text = "Sign up")
        }
    }
}

@DevicesPreview
@Composable
fun SignInPreview() {
    SigInView()
}

@DevicesPreview
@Composable
fun SignUpPreview() {
    SignUpView()
}


