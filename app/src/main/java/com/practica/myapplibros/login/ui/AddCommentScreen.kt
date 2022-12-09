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
fun AddComment(modifier: Modifier, visualModel: AddCommentVisualModel) {

    val texto: String by visualModel.texto.observeAsState(initial = "")
    val usuario: String by visualModel.usuario.observeAsState(initial = "")
    val id_resena: String by visualModel.id_resena.observeAsState(initial = "")
    val AddEnable: Boolean by visualModel.AddEnable.observeAsState(initial = false)
    val isLoading: Boolean by visualModel.isLoading.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()

    if(isLoading){
        Box(Modifier.fillMaxSize()){
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    }else{
        Column(modifier = modifier) {
            MainImageComment(Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(16.dp))
            textoCommentField(texto) {visualModel.onAddCommentChanged(it, usuario, id_resena)}
            Spacer(modifier = Modifier.padding(4.dp))
            usuarioField(usuario) {visualModel.onAddCommentChanged(texto, id_resena, it)}
            Spacer(modifier = Modifier.padding(16.dp))
            id_resenaField(id_resena) {visualModel.onAddCommentChanged(texto, usuario, it)}
            Spacer(modifier = Modifier.padding(16.dp))
            AddButtonComment(AddEnable) {
                coroutineScope.launch {
                    visualModel.onAddCommentSelected()
                }
            }
            Spacer(modifier = Modifier.padding(16.dp))
            ExitButtonComment()
        }
    }
}

@Composable
fun AddCommentScreen(visualModel: AddCommentVisualModel){
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        AddComment(Modifier.align(Alignment.Center), visualModel)
    }
}

@Composable
fun AddButtonComment(AddEnable: Boolean, onCommentSelected: () -> Unit) {
    Button(
        onClick = { onCommentSelected },
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
fun ExitButtonComment() {
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
fun usuarioField(usuario: String, onTextFieldChanged:(String) -> Unit) {
    TextField(value = usuario, onValueChange = {onTextFieldChanged(it)},
        placeholder = { Text(text = "Usuario")},
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
fun textoCommentField(texto: String, onTextFieldChanged:(String) -> Unit) {
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
fun id_resenaField(id_resena: String, onTextFieldChanged:(String) -> Unit) {
    TextField(value = id_resena, onValueChange = {onTextFieldChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Id reseña") },
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
fun MainImageComment(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.addcomment),
        contentDescription = "Header",
        modifier = modifier
    )
}