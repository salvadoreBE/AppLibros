package com.practica.myapplibros.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.practica.myapplibros.R
import com.practica.myapplibros.login.navigation.AppScreens


@Composable
fun Menu(modifier: Modifier, navController: NavController) {

    Scaffold {
        MenuScreen(navController)
    }

        Column(modifier = modifier) {
            HeaderImage(Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(4.dp))
            AddButtonResena(navController)
            Spacer(modifier = Modifier.padding(4.dp))
            AddButtonLibro(navController)
            Spacer(modifier = Modifier.padding(4.dp))
            AddButtonComentario(navController)
            Spacer(modifier = Modifier.padding(4.dp))
            AddButtonExit()
        }
}

@Composable
fun MenuScreen(navController: NavController){
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Menu(Modifier.align(Alignment.Center), navController)
    }
}

@Composable
fun AddButtonResena(navController: NavController) {
    Button(
        onClick = { navController.navigate(route = AppScreens.ThirdScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors =  ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF7BD0DB),
            disabledBackgroundColor = Color(0xFFFFFFFF),
            contentColor = Color.Black,
            disabledContentColor = Color.Black
        )
    ){
        Text(text = "Crear reseña")
    }
}

@Composable
fun AddButtonLibro(navController: NavController) {
    Button(
        onClick = { navController.navigate(route = AppScreens.FourthScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors =  ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF7BD0DB),
            disabledBackgroundColor = Color(0xFFFFFFFF),
            contentColor = Color.Black,
            disabledContentColor = Color.Black
        )
    ){
        Text(text = "Añadir libro")
    }
}

@Composable
fun AddButtonComentario(navController: NavController) {
    Button(
        onClick = { navController.navigate(route = AppScreens.FifthScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors =  ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF7BD0DB),
            disabledBackgroundColor = Color(0xFFFFFFFF),
            contentColor = Color.Black,
            disabledContentColor = Color.Black
        )
    ){
        Text(text = "Añadir comantario")
    }
}

@Composable
fun AddButtonExit() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors =  ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF7BD0DB),
            disabledBackgroundColor = Color(0xFFFFFFFF),
            contentColor = Color.Black,
            disabledContentColor = Color.Black
        )
    ){
        Text(text = "Salir")
    }
}


@Composable
fun Image(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.addbutton),
        contentDescription = "Header",
        modifier = modifier
    )
}