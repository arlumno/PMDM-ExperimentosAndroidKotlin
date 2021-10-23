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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculadoraBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // declaramos botones

        val calculadora = Calculadora();
        calculadora.pushClear()
        //reseteamos valores del layout
        actualizarDisplays(calculadora)

        // botones de 0 al 9
        binding.calc0.setOnClickListener {
            calculadora.pushNumero(0)
            actualizarDisplays(calculadora)
        }

        binding.calc1.setOnClickListener {
            calculadora.pushNumero(1)
            actualizarDisplays(calculadora)
        }

        binding.calc2.setOnClickListener {
            calculadora.pushNumero(2)
            actualizarDisplays(calculadora)
        }

        binding.calc3.setOnClickListener {
            calculadora.pushNumero(3)
            actualizarDisplays(calculadora)
        }

        binding.calc4.setOnClickListener {
            calculadora.pushNumero(4)
            actualizarDisplays(calculadora)
        }

        binding.calc5.setOnClickListener {
            calculadora.pushNumero(5)
            actualizarDisplays(calculadora)
        }

        binding.calc6.setOnClickListener {
            calculadora.pushNumero(6)
            actualizarDisplays(calculadora)
        }

        binding.calc7.setOnClickListener {
            calculadora.pushNumero(7)
            actualizarDisplays(calculadora)
        }

        binding.calc8.setOnClickListener {
            calculadora.pushNumero(8)
            actualizarDisplays(calculadora)
        }

        binding.calc9.setOnClickListener {
            calculadora.pushNumero(9)
            actualizarDisplays(calculadora)
        }

        // operaciones
        binding.calcSumar.setOnClickListener {
            calculadora.pushTipoOperacion("+")
            actualizarDisplays(calculadora)
        }
        binding.calcRestar.setOnClickListener {
            calculadora.pushTipoOperacion("-")
            actualizarDisplays(calculadora)
        }
        binding.calcDividir.setOnClickListener {
            calculadora.pushTipoOperacion("/")
            actualizarDisplays(calculadora)
        }
        binding.calcMultiplicar.setOnClickListener {
            calculadora.pushTipoOperacion("X")
            actualizarDisplays(calculadora)
        }

        //varios
        binding.calcIgual.setOnClickListener {
            calculadora.pushIgual()
            actualizarDisplays(calculadora)
        }
        binding.calcClear.setOnClickListener {
            calculadora.pushClear()
            actualizarDisplays(calculadora)
        }
        binding.calcDel.setOnClickListener {
            calculadora.pushDel()
            actualizarDisplays(calculadora)
        }

        binding.calcPunto.setOnClickListener {
            Toast.makeText(
                this,
                "nada de decimales, de momento es una liada,Not Today...",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    fun actualizarDisplays(calculadora: Calculadora) {
        Log.d("::::Ar", "actualizarDisplays")
        binding.calcDisplay.setText(calculadora.textDisplay)
        binding.calcDisplayMin.setText(calculadora.textDisplayMin)
        //binding.calcDisplayOp.setText(calculadora.textTipoOperacion)
    }

}

