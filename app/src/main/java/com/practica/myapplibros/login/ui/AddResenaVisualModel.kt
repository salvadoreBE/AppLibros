package com.practica.myapplibros.login.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class AddResenaVisualModel : ViewModel(){

    private val _id_usuario = MutableLiveData<String>()
    val id_usuario : LiveData<String> = _id_usuario

    private val _titulo = MutableLiveData<String>()
    val titulo : LiveData<String> = _titulo

    private val _texto = MutableLiveData<String>()
    val texto : LiveData<String> = _texto

    private val _libro = MutableLiveData<String>()
    val libro : LiveData<String> = _libro

    private val _tags = MutableLiveData<String>()
    val tags : LiveData<String> = _tags

    private val _AddEnable = MutableLiveData<Boolean>()
    val AddEnable : LiveData<Boolean> = _AddEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    fun onAddResenaChanged(id_usuario: String, titulo: String, texto: String, libro: String, tags: String) {
        _id_usuario.value = id_usuario
        _titulo.value = titulo
        _texto.value = texto
        _libro.value = libro
        _tags.value = tags
        _AddEnable.value = isValidId_usuario(id_usuario) && isValidTitulo(titulo) && isValidTexto(texto)
                && isValidLibro(libro) && isValidTag(tags)
    }

    private fun isValidId_usuario(id_usuario: String): Boolean = id_usuario.length in 1..149

    private fun isValidTitulo(titulo: String): Boolean = titulo.length > 2

    private fun isValidTexto(texto: String): Boolean = texto.length > 2

    private fun isValidLibro(libro: String): Boolean = libro.length > 2

    private fun isValidTag(tag: String): Boolean = tag.length > 2

    suspend fun onAddResenaSelected() {
        _isLoading.value = true
        delay(4000)
        _isLoading.value = false
    }

}