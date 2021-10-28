package com.example.pmdm_experimentosandroidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmdm_experimentosandroidkotlin.databinding.ActivityContadoresBinding

class ContadoresActivity : AppCompatActivity() {
    private lateinit var binding:ActivityContadoresBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContadoresBinding.inflate(layoutInflater);
        setContentView(binding.root)

        var contador:Int = 0

        binding.botonSumar.setOnClickListener {
            contador++
            binding.textoContador.setText(contador.toString())
        }

        binding.botonRestar.setOnClickListener {
            contador--
            binding.textoContador.setText(contador.toString())
        }
        binding.irMain.setOnClickListener{
            val intent = Intent(
                this,  // https://kotlinlang.org/docs/this-expressions.html#qualified
                MainActivity::class.java
            )
            startActivity(intent)
        }
    }
}