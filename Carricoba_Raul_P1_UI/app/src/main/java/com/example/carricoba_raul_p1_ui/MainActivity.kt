package com.example.carricoba_raul_p1_ui

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

        binding.btnEj1.setOnClickListener {
            val intent = Intent(this, Ej1Activity::class.java)
            startActivity(intent)
        }
        binding.btnEj2.setOnClickListener {
            val intent = Intent(this, Ej2Activity::class.java)
            startActivity(intent)
        }
        binding.btnEj3.setOnClickListener {
            val intent = Intent(this, Ej3Activity::class.java)
            startActivity(intent)
        }
        binding.btnEj4.setOnClickListener {
            val intent = Intent(this, Ej4Activity::class.java)
            startActivity(intent)
        }
        binding.btnEj5.setOnClickListener {
            val intent = Intent(this, Ej5Activity::class.java)
            startActivity(intent)
        }
        binding.btnEj6.setOnClickListener {
            val intent = Intent(this, Ej6Activity::class.java)
            startActivity(intent)
        }
        binding.btnEj7.setOnClickListener {
            val intent = Intent(this, Ej7Activity::class.java)
            startActivity(intent)
        }
        binding.btnEj8.setOnClickListener {
            val intent = Intent(this, Ej8Activity::class.java)
            startActivity(intent)
        }
        binding.btnEj9.setOnClickListener {
            val intent = Intent(this, Ej9Activity::class.java)
            startActivity(intent)
        }
        binding.btnEj10.setOnClickListener {
            val intent = Intent(this, Ej10Activity::class.java)
            startActivity(intent)
        }
        binding.btnEj11.setOnClickListener {
            val intent = Intent(this, Ej11Activity::class.java)
            startActivity(intent)
        }
    }
}