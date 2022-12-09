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
import androidx.navigation.NavController
import com.practica.myapplibros.R
import kotlinx.coroutines.launch



@Composable
fun AddResena(modifier: Modifier, visualModel: AddResenaVisualModel) {

    val id_usuario: String by visualModel.id_usuario.observeAsState(initial = "")
    val titulo: String by visualModel.titulo.observeAsState(initial = "")
    val texto: String by visualModel.texto.observeAsState(initial = "")
    val libro: String by visualModel.libro.observeAsState(initial = "")
    val tags: String by visualModel.tags.observeAsState(initial = "")
    val AddEnable: Boolean by visualModel.AddEnable.observeAsState(initial = false)
    val isLoading: Boolean by visualModel.isLoading.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()

    if(isLoading){
        Box(Modifier.fillMaxSize()){
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    }else{
        Column(modifier = modifier) {
            MainImage(Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(16.dp))
            id_usuarioField(id_usuario) {visualModel.onAddResenaChanged(it, titulo, texto, libro, tags)}
            Spacer(modifier = Modifier.padding(4.dp))
            tituloField(titulo) {visualModel.onAddResenaChanged(id_usuario, texto, libro, tags, it)}
            Spacer(modifier = Modifier.padding(16.dp))
            textoField(texto) {visualModel.onAddResenaChanged(id_usuario, titulo, libro, tags, it)}
            Spacer(modifier = Modifier.padding(16.dp))
            libroField(libro) {visualModel.onAddResenaChanged(id_usuario, titulo, texto, tags, it)}
            Spacer(modifier = Modifier.padding(16.dp))
            tagsField(tags) {visualModel.onAddResenaChanged(id_usuario, titulo, texto, libro, it)}
            Spacer(modifier = Modifier.padding(16.dp))
            AddButton(AddEnable) {
                coroutineScope.launch {
                    visualModel.onAddResenaSelected()
                }
            }
            Spacer(modifier = Modifier.padding(16.dp))
            ExitButtonResena()
        }
    }
}

@Composable
fun AddResenaScreen(visualModel: AddResenaVisualModel){
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        AddResena(Modifier.align(Alignment.Center), visualModel)
    }
}

@Composable
fun AddButton(AddEnable: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected },
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
fun ExitButtonResena() {
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
fun id_usuarioField(id_usuario: String, onTextFieldChanged:(String) -> Unit) {
    TextField(value = id_usuario, onValueChange = {onTextFieldChanged(it)},
        placeholder = { Text(text = "id_usuario")},
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
fun tituloField(titulo: String, onTextFieldChanged:(String) -> Unit) {
    TextField(value = titulo, onValueChange = {onTextFieldChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Titulo") },
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
fun textoField(texto: String, onTextFieldChanged:(String) -> Unit) {
    TextField(value = texto, onValueChange = {onTextFieldChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Texto") },
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
fun libroField(libro: String, onTextFieldChanged:(String) -> Unit) {
    TextField(value = libro, onValueChange = {onTextFieldChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Libro") },
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
fun tagsField(tags: String, onTextFieldChanged:(String) -> Unit) {
    TextField(value = tags, onValueChange = {onTextFieldChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Tags") },
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
fun MainImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.addresena),
        contentDescription = "Header",
        modifier = modifier
    )
}