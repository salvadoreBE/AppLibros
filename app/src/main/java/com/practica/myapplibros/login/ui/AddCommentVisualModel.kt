package com.practica.myapplibros.login.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class AddCommentVisualModel : ViewModel(){

    private val _texto = MutableLiveData<String>()
    val texto : LiveData<String> = _texto

    private val _usuario = MutableLiveData<String>()
    val usuario : LiveData<String> = _usuario

    private val _id_resena = MutableLiveData<String>()
    val id_resena : LiveData<String> = _id_resena

    private val _AddEnable = MutableLiveData<Boolean>()
    val AddEnable : LiveData<Boolean> = _AddEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    fun onAddCommentChanged(texto: String, usuario: String, id_resena: String) {
        _texto.value = texto
        _usuario.value = usuario
        _id_resena.value = id_resena
        _AddEnable.value = isValidTexto(texto) && isValidUsuario(usuario) && isValidId_resena(id_resena)
    }

    private fun isValidId_resena(id_resena: String): Boolean = id_resena.length in 1..149

    private fun isValidUsuario(usuario: String): Boolean = usuario.length > 2

    private fun isValidTexto(texto: String): Boolean = texto.length > 2


    suspend fun onAddCommentSelected() {
        _isLoading.value = true
        delay(4000)
        _isLoading.value = false
    }

}