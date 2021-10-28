package com.example.pmdm_experimentosandroidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.pmdm_experimentosandroidkotlin.databinding.ActivityCalculadoraBinding
import com.example.pmdm_experimentosandroidkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    var countClicker = 0
    lateinit var clicker : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
// agregar varios onclickEvent.
// aplicar estilo desde codigo

        clicker = TextView(
            this,
            null,
            R.style.clickerStyle,
            R.style.clickerStyle
        ) // https://www.py4u.net/discuss/608353
        //clicker.textSize = 30f
        //clicker.setTextAppearance(R.style.clickerStyle)
        clicker.setText(countClicker.toString())

        // clicker.setBackgroundResource(R.style.clickerStyle)
        binding.root.addView(clicker)
        binding.root.setOnClickListener {
          contadorGeneral()
        }


        binding.irCalculadora.setOnClickListener {
            val intent = Intent(
                this,
                CalculadoraActivity::class.java
            )
            startActivity(intent)
        }

        binding.irContadores.setOnClickListener {
            val intent = Intent(
                this,
                ContadoresActivity::class.java
            )
            startActivity(intent)
        }
//        binding.irContadores.setOnClickListener {
//            Toast.makeText(this, "aqui", Toast.LENGTH_LONG).show()
//            contadorGeneral()
//        }
    }

    private fun contadorGeneral() {
        countClicker++
        clicker.setText(countClicker.toString())
    }
}