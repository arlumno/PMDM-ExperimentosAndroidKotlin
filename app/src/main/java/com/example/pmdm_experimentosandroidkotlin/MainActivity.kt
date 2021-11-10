package com.example.pmdm_experimentosandroidkotlin


import com.example.pmdm_experimentosandroidkotlin.ClickerTracker
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.pmdm_experimentosandroidkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val clickerTracker = ClickerTracker();
        clickerTracker.start(this, binding.clickerLinearLayout);


        binding.tvPrueba.setOnClickListener {
            clickerTracker.track(this, it)
        }

        binding.botonPrueba.setOnClickListener {
            clickerTracker.track(this, it)
        }

        binding.irCalculadora.setOnClickListener {
            clickerTracker.track(this, it)

            val intent = Intent(
                this,
                CalculadoraActivity::class.java
            )
            startActivity(intent)
        }

        binding.irContadores.setOnClickListener {
            clickerTracker.track(this, it)
            val intent = Intent(
                this,
                ContadoresActivity::class.java
            )
            startActivity(intent)
        }

        binding.botonLog.setOnClickListener{
            clickerTracker.track(this, it)
            clickerTracker.mostrarLog(this)
        }

        binding.botonTest.setOnClickListener {
            clickerTracker.track(this, it)
            binding.botonTest.setText("alehop!")
            it.animate().rotation(3600F).setDuration(3000).withEndAction {
                binding.botonTest.setText("tachan!!!")
                binding.botonTest.setRotation(0F)
                mostrarToast("10 - 9 - 10")

                binding.botonTest.setOnClickListener {
                    mostrarToast("No puedo.. Necesito descansar..")
                }

            }
            binding.imgC3po.animate().rotation(-3600F).setDuration(3000).withEndAction {
                binding.botonTest.setRotation(0F)
            }
        }
    }

}