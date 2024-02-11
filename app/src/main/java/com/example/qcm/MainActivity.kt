package com.example.qcm


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.qcm.ui.theme.QCMTheme
import com.example.qcm.ui.theme.screen.HomeRender
import com.example.qcm.ui.theme.screen.ListQCM
import com.example.qcm.ui.theme.screen.QuestionRender


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QCMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "Home") {
                        composable("Home") {  }
                        composable("Question") {  }
                    }
                }
            }
        }
    }
}

@Composable
fun Screen1(navController: NavHostController) {
    HomeRender()
}


