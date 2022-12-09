package com.practica.myapplibros.login.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class AddLibroVisualModel : ViewModel(){

    private val _titulo = MutableLiveData<String>()
    val titulo : LiveData<String> = _titulo

    private val _descripcion = MutableLiveData<String>()
    val descripcion : LiveData<String> = _descripcion

    private val _autores = MutableLiveData<String>()
    val autores : LiveData<String> = _autores

    private val _AddEnable = MutableLiveData<Boolean>()
    val AddEnable : LiveData<Boolean> = _AddEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    fun onAddLibroChanged(titulo: String, descripcion: String, autores: String) {
        _titulo.value = titulo
        _descripcion.value = descripcion
        _autores.value = autores
        _AddEnable.value = isValidTitulo(titulo) && isValidDescripcion(descripcion) && isValidAutores(autores)
    }

    private fun isValidTitulo(titulo: String): Boolean = titulo.length > 2

    private fun isValidDescripcion(descripcion: String): Boolean = descripcion.length > 2

    private fun isValidAutores(autores: String): Boolean = autores.length > 2


    suspend fun onAddLibroSelected() {
        _isLoading.value = true
        delay(4000)
        _isLoading.value = false
    }

}