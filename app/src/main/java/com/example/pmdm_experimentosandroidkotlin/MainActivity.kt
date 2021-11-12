package com.example.pmdm_experimentosandroidkotlin


import com.example.pmdm_experimentosandroidkotlin.ClickerTracker
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        var iniR2d2: Float? = null
        binding.botonNoTocar.setOnClickListener {
            if(iniR2d2 == null){
                iniR2d2 =  binding.imgR2d2.x
            }
            Log.d(":::ar", "Inicio: $iniR2d2")
            clickerTracker.track(this, it)
            var movimiento = binding.imgC3po.right - binding.imgR2d2.left - (binding.imgC3po.width / 2)
            Log.d(":::ar", "Movimiento: $movimiento")
            binding.imgR2d2.animate().translationX(movimiento.toFloat()).setDuration(200).withEndAction{
                binding.imgR2d2.animate().x((binding.imgR2d2.width * -1).toFloat()) .setDuration(300).withEndAction{
                    binding.imgR2d2.x = iniR2d2!!
                }
                binding.imgC3po.animate().rotation(1800F).setDuration(2000).withEndAction {
                    binding.imgC3po.setRotation(0F)
                }
            }
            //mostrarToast("Algo: " + movimiento.toString())
//            it.animate().rotation(3600F).setDuration(3000).withEndAction {
//                binding.botonNoTocar.setText("tachan!!!")
//                binding.botonNoTocar.setRotation(0F)
//                mostrarToast("10 - 9 - 10")
//
//                binding.botonNoTocar.setOnClickListener {
//                    mostrarToast("No puedo.. Necesito descansar..")
//                }
//
//            }
        }
    }

    override fun onStart() {
        super.onStart()
        //  // sigue dando 0...
    }
}