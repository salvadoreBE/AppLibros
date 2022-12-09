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
import androidx.compose.ui.unit.dp
import com.practica.myapplibros.R
import kotlinx.coroutines.launch



@Composable
fun AddLibro(modifier: Modifier, visualModel: AddLibroVisualModel) {

    val titulo: String by visualModel.titulo.observeAsState(initial = "")
    val descripcion: String by visualModel.descripcion.observeAsState(initial = "")
    val autores: String by visualModel.autores.observeAsState(initial = "")
    val AddEnable: Boolean by visualModel.AddEnable.observeAsState(initial = false)
    val isLoading: Boolean by visualModel.isLoading.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()

    if(isLoading){
        Box(Modifier.fillMaxSize()){
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    }else{
        Column(modifier = modifier) {
            MainImageLibro(Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(16.dp))
            tituloLibroField(titulo) {visualModel.onAddLibroChanged(it, descripcion, autores)}
            Spacer(modifier = Modifier.padding(4.dp))
            descripcionField(descripcion) {visualModel.onAddLibroChanged(titulo, autores, it)}
            Spacer(modifier = Modifier.padding(16.dp))
            autoresField(autores) {visualModel.onAddLibroChanged(titulo, descripcion, it)}
            Spacer(modifier = Modifier.padding(16.dp))
            AddButtonLibro(AddEnable) {
                coroutineScope.launch {
                    visualModel.onAddLibroSelected()
                }
            }
            Spacer(modifier = Modifier.padding(16.dp))
            ExitButtonLibro()
        }
    }
}

@Composable
fun AddLibroScreen(visualModel: AddLibroVisualModel){
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        AddLibro(Modifier.align(Alignment.Center), visualModel)
    }
}

@Composable
fun AddButtonLibro(AddEnable: Boolean, onLibroSelected: () -> Unit) {
    Button(
        onClick = { onLibroSelected },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors =  ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFF0EDED),
            disabledBackgroundColor = Color(0xFFFFFFFF),
            contentColor = Color.Black,
            disabledContentColor = Color.Black
        ), enabled = AddEnable
    ){
        Text(text = "Añadir")
    }
}

@Composable
fun ExitButtonLibro() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors =  ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFF0EDED),
            disabledBackgroundColor = Color(0xFFFFFFFF),
            contentColor = Color.Black,
            disabledContentColor = Color.Black
        )
    ){
        Text(text = "Salir")
    }
}

@Composable
fun tituloLibroField(titulo: String, onTextFieldChanged:(String) -> Unit) {
    TextField(value = titulo, onValueChange = {onTextFieldChanged(it)},
        placeholder = { Text(text = "Titulo")},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
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
fun descripcionField(descripcion: String, onTextFieldChanged:(String) -> Unit) {
    TextField(value = descripcion, onValueChange = {onTextFieldChanged(it)},
        placeholder = { Text(text = "Descripcion")},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
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
fun autoresField(autores: String, onTextFieldChanged:(String) -> Unit) {
    TextField(value = autores, onValueChange = {onTextFieldChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Autores") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
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
fun MainImageLibro(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.addcomment),
        contentDescription = "Header",
        modifier = modifier
    )
}