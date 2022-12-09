package com.practica.myapplibros.login.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class LoginVisualModel : ViewModel(){

    private val _nombre = MutableLiveData<String>()
    val nombre : LiveData<String> = _nombre

    private val _edad = MutableLiveData<String>()
    val edad : LiveData<String> = _edad

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable : LiveData<Boolean> = _loginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    fun onLoginChanged(nombre: String, edad: String) {
        _nombre.value = nombre
        _edad.value = edad
        _loginEnable.value = isValidNombre(nombre) && isValidEdad(edad)
    }

    private fun isValidEdad(edad: String): Boolean = edad.length in 1..149

    private fun isValidNombre(nombre: String): Boolean = nombre.length > 2

    suspend fun onLoginSelected() {
        _isLoading.value = true
        delay(4000)
        _isLoading.value = false
    }

}