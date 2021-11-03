package com.example.pmdm_experimentosandroidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.pmdm_experimentosandroidkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var clickerLinearLayout : LinearLayout
    lateinit var clicker : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
// ----agregar varios onclickEvent.
// aplicar estilo desde código
// cambiar posicion desde código
        clickerLinearLayout = LinearLayout(this, null, R.style.clickerLinearLayout,R.style.clickerLinearLayout)
        clicker = TextView(this, null, R.style.clickerStyle, R.style.clickerStyle) // https://www.py4u.net/discuss/608353
        clicker.setText(objetoDatos.clicks.toString())

        clickerLinearLayout.addView(clicker)

        // clicker.setBackgroundResource(R.style.clickerStyle)
        binding.root.addView(clickerLinearLayout)
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
        binding.botonTest.setOnClickListener {
            binding.botonTest.setText("alehop!")
            it.animate().rotation(3600F).setDuration(3000).withEndAction {
                binding.botonTest.setText("tachan!!!")
                binding.botonTest.setRotation(0F)
                mostrarToast("10 - 9 - 10")

                binding.botonTest.setOnClickListener {
                    mostrarToast("No puedo.. Necesito descansar..")
                }
            };

            contadorGeneral()
        }
    }

    private fun contadorGeneral() {
        objetoDatos.clicks++
        mostrarToast(objetoDatos.clicks.toString())
        clicker.setText(objetoDatos.clicks.toString())
    }
}