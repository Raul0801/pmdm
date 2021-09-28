package com.example.holamundo01

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.holamundo01.databinding.ActivityMainBinding

class MainActivityKotlin : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Entraste en la activity de kotlin")
    }

}