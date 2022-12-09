package com.practica.myapplibros.login.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class MenuVisualMode : ViewModel(){

    private val _menuEnable = MutableLiveData<Boolean>()
    val menuEnable : LiveData<Boolean> = _menuEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading


}