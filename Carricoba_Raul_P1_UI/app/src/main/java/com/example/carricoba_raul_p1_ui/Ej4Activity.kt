package com.example.carricoba_raul_p1_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.carricoba_raul_p1_ui.databinding.ActivityEj4Binding

class Ej4Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEj4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEj4Binding.inflate(layoutInflater)

        setContentView(R.layout.activity_ej4)
        setContentView(binding.root)

        binding.button.setOnClickListener {v -> onClickButton(v)}
        binding.button2.setOnClickListener {v -> onClickButton(v)}
        binding.button3.setOnClickListener {v -> onClickButton(v)}
    }

    private fun onClickButton(v: View) {
        val but = v as Button
        Toast.makeText(this, v.text, Toast.LENGTH_SHORT).show()
    }
}