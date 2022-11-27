package com.example.compose_list_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose_list_sample.ui.screen.AllCharScreen
import com.example.compose_list_sample.ui.screen.CharDetailScreen
import com.example.compose_list_sample.ui.theme.ComposelistsampleTheme
import com.example.compose_list_sample.viewModel.GenshinCharViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposelistsampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val charViewModel: GenshinCharViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = NavScreen.getStartDestination()
    ) {
        composable(NavScreen.AllChar.route) { AllCharScreen(navController, charViewModel) }
        composable(NavScreen.CharDetails.route) { CharDetailScreen(navController, charViewModel) }
    }

}


sealed class NavScreen(val route: String) {
    object AllChar : NavScreen("all_char")
    object CharDetails : NavScreen("details")

    companion object {
        fun getStartDestination() = AllChar.route
    }
}



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposelistsampleTheme {
        Greeting("Android")
    }
}