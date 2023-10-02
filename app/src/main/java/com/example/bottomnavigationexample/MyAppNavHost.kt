package com.example.bottomnavigationexample

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

private fun NavGraphBuilder.mainScreen() {
    navigation(route = "main", startDestination = "main/entry") {
        composable("main/entry") {
            MainScreen()
        }
    }
}

@Composable
fun MyAppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "main"
) {
    NavHost(navController = navController, startDestination = startDestination) {
        mainScreen()
    }
}