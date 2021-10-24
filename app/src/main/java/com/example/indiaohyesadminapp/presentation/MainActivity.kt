package com.example.indiaohyesadminapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.indiaohyesadminapp.presentation.categories_list.CategoriesListScreen
import com.example.indiaohyesadminapp.presentation.theme.IndiaOhYesAdminAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IndiaOhYesAdminAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CategoriesListScreen.route
                    ) {
                        composable(
                            route = Screen.CategoriesListScreen.route
                        ) {
                            CategoriesListScreen(navController)
                        }
                        composable(
                            route = Screen.CategoryScreen.route + "/{coinId}"
                        ) {
                            Screen.CategoryScreen
                        }
                    }
                }
                }
            }
        }
    }




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IndiaOhYesAdminAppTheme {

    }
}