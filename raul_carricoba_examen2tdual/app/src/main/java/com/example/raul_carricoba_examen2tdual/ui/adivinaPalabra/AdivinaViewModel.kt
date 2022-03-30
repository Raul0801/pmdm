package com.example.raul_carricoba_examen2tdual.ui.adivinaPalabra

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.raul_carricoba_examen2tdual.R

class AdivinaViewModel(application: Application) : AndroidViewModel(application) {
    private val resources = application.resources
    var finished = MutableLiveData(false)
    var word = MutableLiveData("")
    var score = MutableLiveData(0)

    private lateinit var wordList: MutableList<String>


    init {
        Log.i("GameViewModel", "GameViewModel created!")
        resetList()
        nextWord()
    }

    private fun resetList() {
        wordList = resources.getStringArray(R.array.palabras).toMutableList().apply { shuffle() }
        // TODO: Igual tiene sentido cargarla primero y solo barajar en cada reset?
    }


    /**
     * Callback called when the ViewModel is destroyed
     */
    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    /** Methods for updating the UI **/
    fun onSkip() {
        // https://stackoverflow.com/questions/57219811/is-it-possible-to-increment-mutablelivedata-without-additional-variable
        score.value?.let { a -> score.value = a-1 }
        nextWord()
    }

    fun onCorrect() {
        score.value?.let { a -> score.value = a+1 }
        nextWord()
    }

    /**
     * Moves to the next word in the list.
     */
    private fun nextWord() {
        if (wordList.isNotEmpty()) {
            word.postValue(wordList.removeAt(0))
        } else {
            finished.value?.let { a -> finished.value = true }
        }
    }
}