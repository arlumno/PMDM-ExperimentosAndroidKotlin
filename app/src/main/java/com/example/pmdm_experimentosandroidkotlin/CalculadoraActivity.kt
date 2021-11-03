package com.example.pmdm_experimentosandroidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.pmdm_experimentosandroidkotlin.databinding.ActivityCalculadoraBinding
import kotlin.math.log

class CalculadoraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculadoraBinding

    val calculadora = Calculadora();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculadoraBinding.inflate(layoutInflater)

        setContentView(binding.root)


        calculadora.pushClear()
        //reseteamos valores del layout a los de la calculadora
        actualizarDisplays()

        // botones de 0 al 9
        binding.calc0.setOnClickListener { pushButton(0) }

        binding.calc1.setOnClickListener { pushButton(1) }

        binding.calc2.setOnClickListener { pushButton(2) }

        binding.calc3.setOnClickListener { pushButton(3) }

        binding.calc4.setOnClickListener { pushButton(4) }

        binding.calc5.setOnClickListener { pushButton(5) }

        binding.calc6.setOnClickListener { pushButton(6) }

        binding.calc7.setOnClickListener { pushButton(7) }

        binding.calc8.setOnClickListener { pushButton(8) }

        binding.calc9.setOnClickListener { pushButton(9) }

        // operaciones
        binding.calcSumar.setOnClickListener {
            calculadora.pushTipoOperacion("+")
            actualizarDisplays()
        }
        binding.calcRestar.setOnClickListener {
            calculadora.pushTipoOperacion("-")
            actualizarDisplays()
        }
        binding.calcDividir.setOnClickListener {
            calculadora.pushTipoOperacion("/")
            actualizarDisplays()
        }
        binding.calcMultiplicar.setOnClickListener {
            calculadora.pushTipoOperacion("X")
            actualizarDisplays()
        }

        //varios
        binding.calcIgual.setOnClickListener {
            calculadora.pushIgual()
            actualizarDisplays()
        }
        binding.calcClear.setOnClickListener {
            calculadora.pushClear()
            actualizarDisplays()
        }
        binding.calcDel.setOnClickListener {
            calculadora.pushDel()
            actualizarDisplays()
        }

        binding.calcPunto.setOnClickListener {
            Toast.makeText(
                this,
                "nada de decimales de momento, es una liada, Not Today...",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.irMain.setOnClickListener {
            val intent = Intent(
                this,  // https://kotlinlang.org/docs/this-expressions.html#qualified
                MainActivity::class.java
            )
            startActivity(intent)
        }

    }

    fun pushButton(numero: Int) {
        calculadora.pushNumero(numero)
        actualizarDisplays()
    }

    fun actualizarDisplays() {
        Log.d("::::Ar", "actualizarDisplays")
        binding.calcDisplay.setText(calculadora.textDisplay)
        binding.calcDisplayMin.setText(calculadora.textDisplayMin)
    }


}

