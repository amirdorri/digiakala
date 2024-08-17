package com.example.digikala.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.digikala.ui.screens.basketScreen
import com.example.digikala.ui.screens.categoryScreen
import com.example.digikala.ui.screens.home.HomeScreen
import com.example.digikala.ui.screens.profileScreen
import com.example.digikala.ui.screens.splashScreen

@Composable
fun setupNavGraph(navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = Screen.Splash.route) {

        composable(Screen.Splash.route){
            splashScreen(navController)
        }

        composable(Screen.Home.route){
            HomeScreen(navController)
        }

        composable(Screen.Category.route){
            categoryScreen(navController)
        }

        composable(Screen.Basket.route){
            basketScreen(navController)
        }

        composable(Screen.Profile.route){
            profileScreen(navController)
        }


    }

}
