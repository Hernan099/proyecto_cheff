package com.example.my_application

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val boton1: Button = findViewById(R.id.button)

        boton1.setOnClickListener { ingreseNombre() }

    }

    private fun ingreseNombre() {

        val campoNombre: EditText = findViewById(R.id.editTextText)
        val name = campoNombre.text

        Toast.makeText(this, "Bienvenido ¡$name!",Toast.LENGTH_LONG).show()
    }
}