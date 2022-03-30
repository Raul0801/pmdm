package com.example.raul_carricoba_examen2tdual.ui.inicio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InicioViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Selecciona el juego en el menú lateral"
    }
    val text: LiveData<String> = _text
}