package com.practica.myapplibros.login.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.practica.myapplibros.login.ui.LoginScreen
import com.practica.myapplibros.login.ui.LoginVisualModel
import com.practica.myapplibros.login.ui.MenuScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController =navController, startDestination = AppScreens.FirstScreen.route){
        composable(route = AppScreens.FirstScreen.route){
            LoginScreen(visualModel = LoginVisualModel(), navController)
        }
        composable(route = AppScreens.SecondScreen.route){
            MenuScreen(navController)
        }
    }
}