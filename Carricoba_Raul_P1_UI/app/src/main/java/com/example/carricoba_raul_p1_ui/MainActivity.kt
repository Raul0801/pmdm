package com.example.carricoba_raul_p1_ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carricoba_raul_p1_ui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.btnEj1.setOnClickListener {moveToActivity(this, Ej1Activity::class.java)}
        binding.btnEj2.setOnClickListener {moveToActivity(this, Ej2Activity::class.java)}
        binding.btnEj3.setOnClickListener {moveToActivity(this, Ej3Activity::class.java)}
        binding.btnEj4.setOnClickListener {moveToActivity(this, Ej4Activity::class.java)}
        binding.btnEj5.setOnClickListener {moveToActivity(this, Ej5Activity::class.java)}
        binding.btnEj6.setOnClickListener {moveToActivity(this, Ej6Activity::class.java)}
        binding.btnEj7.setOnClickListener {moveToActivity(this, Ej7Activity::class.java)}
        binding.btnEj8.setOnClickListener {moveToActivity(this, Ej8Activity::class.java)}
        binding.btnEj9.setOnClickListener {moveToActivity(this, Ej9Activity::class.java)}
        binding.btnEj10.setOnClickListener {moveToActivity(this, Ej10Activity::class.java)}
        binding.btnEj11.setOnClickListener {moveToActivity(this, Ej11Activity::class.java)}
    }

    fun moveToActivity(activity: Activity, clase: Class<*>?) {
        val intent = Intent(activity, clase)
        startActivity(intent)
    }

}