package com.example.expensetracker

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme
import com.example.expensetracker.view.login.ForgotPasswordView
import com.example.expensetracker.view.login.SigInView
import com.example.expensetracker.view.login.SignUpView
import com.example.expensetracker.view.StartupNavigationView
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    StartupNavigationView()
                }
            }
        }
    }
}

@DevicesPreview
@Composable
fun SignInPreview() {
    val navController = rememberNavController()
    SigInView(navController)
}

@DevicesPreview
@Composable
fun SignUpPreview() {
    val navController = rememberNavController()
    SignUpView(navController)
}

@DevicesPreview
@Composable
fun ForgotPasswordPreview() {
    val navController = rememberNavController()
    ForgotPasswordView(navController)
}


