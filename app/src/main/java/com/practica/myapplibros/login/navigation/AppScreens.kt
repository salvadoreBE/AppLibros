package com.practica.myapplibros.login.navigation

sealed class AppScreens(val route: String){
    object FirstScreen: AppScreens("LoginScreen")
    object SecondScreen: AppScreens("MenuScreen")
    object ThirdScreen: AppScreens("AddResenaScreen")
    object FourthScreen: AppScreens("AddLibroScreen")
    object FifthScreen: AppScreens("AddCommentScreen")
}
