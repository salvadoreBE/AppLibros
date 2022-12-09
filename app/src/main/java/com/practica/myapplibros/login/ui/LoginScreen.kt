package com.practica.myapplibros.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.practica.myapplibros.R
import com.practica.myapplibros.login.navigation.AppScreens
import kotlinx.coroutines.launch



@Composable
fun Login(modifier: Modifier, visualModel: LoginVisualModel, navController: NavController) {

    Scaffold {
        LoginScreen(visualModel, navController)
    }

    val nombre: String by visualModel.nombre.observeAsState(initial = "")
    val edad: String by visualModel.edad.observeAsState(initial = "")
    val loginEnable: Boolean by visualModel.loginEnable.observeAsState(initial = false)
    val isLoading: Boolean by visualModel.isLoading.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()

    if(isLoading){
        Box(Modifier.fillMaxSize()){
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    }else{
        Column(modifier = modifier) {
            HeaderImage(Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(16.dp))
            NombreField(nombre) {visualModel.onLoginChanged(it, edad)}
            Spacer(modifier = Modifier.padding(4.dp))
            EdadField(edad) {visualModel.onLoginChanged(nombre, it)}
            Spacer(modifier = Modifier.padding(16.dp))
            LoginButton(loginEnable) {
                coroutineScope.launch {
                    visualModel.onLoginSelected()
                }
            }
            Spacer(modifier = Modifier.padding(4.dp))
            IrButton(navController)
            Spacer(modifier = Modifier.padding(16.dp))
            ExitButton()
        }
    }
}

@Composable
fun LoginScreen(visualModel: LoginVisualModel, navController: NavController){
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Login(Modifier.align(Alignment.Center), visualModel, navController)
    }
}

@Composable
fun LoginButton(loginEnable: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors =  ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF505050),
            disabledBackgroundColor = Color(0xFFFFFFFF),
            contentColor = Color.Black,
            disabledContentColor = Color.Black
        ), enabled = loginEnable
    ){
        Text(text = "Iniciar")
    }
}

@Composable
fun IrButton(navController: NavController) {
    Button(
        onClick = { navController.navigate(route = AppScreens.SecondScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors =  ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF505050),
            disabledBackgroundColor = Color(0xFFFFFFFF),
            contentColor = Color.Black,
            disabledContentColor = Color.Black
        )
    ){
        Text(text = "Iniciar")
    }
}

@Composable
fun ExitButton() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors =  ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF00BCD4),
            disabledBackgroundColor = Color(0xFFFFFFFF),
            contentColor = Color.Black,
            disabledContentColor = Color.Black
        )
    ){
        Text(text = "Salir")
    }
}

@Composable
fun EdadField(edad: String, onTextFieldChanged:(String) -> Unit) {
    TextField(value = edad, onValueChange = {onTextFieldChanged(it)},
        placeholder = { Text(text = "Edad")},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF97A2DB),
            backgroundColor = Color(0xFFEAEBEE),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun NombreField(nombre: String, onTextFieldChanged:(String) -> Unit) {
    TextField(value = nombre, onValueChange = {onTextFieldChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Nombre") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF97A2DB),
            backgroundColor = Color(0xFFEAEBEE),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.img),
        contentDescription = "Header",
        modifier = modifier
    )
}