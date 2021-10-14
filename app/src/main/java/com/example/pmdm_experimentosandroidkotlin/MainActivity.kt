package com.example.pmdm_experimentosandroidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // *** Inicio Contador
        var contador:Int = 0
        val botonSumar = findViewById<Button>(R.id.botonSumar)
        val botonRestar = findViewById<Button>(R.id.botonRestar)
        val textoContador = findViewById<EditText>(R.id.textoContador)

        botonSumar.setOnClickListener {
            contador++
            textoContador.setText(contador.toString())
        }

        botonRestar.setOnClickListener {
            contador--
            textoContador.setText(contador.toString())
        }
        // *** Fin Contador
        // *** Inicio Calculadora con layout

        val calculadora = findViewById<Button>(R.id.calculadora)
        calculadora.setOnClickListener{
            val intent = Intent(
                this@MainActivity,  // https://kotlinlang.org/docs/this-expressions.html#qualified
                CalculadoraActivity::class.java
            )
            startActivity(intent)
        }
    }

}