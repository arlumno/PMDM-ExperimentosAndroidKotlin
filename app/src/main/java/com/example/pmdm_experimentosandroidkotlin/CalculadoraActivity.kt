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
            calculadora.pushOperacion("+")
            actualizarDisplays(calculadora)
        }
        binding.calcRestar.setOnClickListener {
            calculadora.pushOperacion("-")
            actualizarDisplays(calculadora)
        }
        binding.calcDividir.setOnClickListener {
            calculadora.pushOperacion("/")
            actualizarDisplays(calculadora)
        }
        binding.calcMultiplicar.setOnClickListener {
            calculadora.pushOperacion("X")
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
        binding.calcDisplayOp.setText(calculadora.textOperacion)
    }

    fun addNumero(numero: Int, numeroDisplay: Int): Int {
        var resultadoOperacion: Long = numeroDisplay.toLong() * 10 + numero;
        if (resultadoOperacion.toString().length > 8) {
            resultadoOperacion = numeroDisplay.toLong();
        }
        return resultadoOperacion.toInt();
    }
}

class Calculadora {
    var numeroActual: Long? = null
    var numeroAnterior: Long? = null
    var operacion: String = ""
    var resultadoUltimaOperacion: String? = null
    val maxDigitos = 9

    val textDisplay: String
        get() = numeroActual?.toString() ?: numeroAnterior?.toString()?: resultadoUltimaOperacion ?: "0"

    val textDisplayMin: String
        get() = numeroAnterior?.toString() ?: ""

    val textOperacion: String
        get() = operacion


    fun pushNumero(numeroPulsado: Int) {
        Log.d("::::Ar", "pushNumero numero: $numeroPulsado")
        if ((numeroActual ?: 0).toString().length < maxDigitos) numeroActual = (numeroActual ?: 0) * 10 + numeroPulsado.toLong()
        Log.d("::::Ar", "pushNumero display $numeroActual")
    }

    fun pushPunto() {

    }

    fun pushOperacion(operacionPulsada: String) {
        if(numeroAnterior == null){
            numeroActual.let {
                numeroAnterior = numeroActual
                numeroActual = null
            }
        }
        numeroActual = null
        operacion = operacionPulsada

    }


    fun pushClear() {
        numeroActual = null
        numeroAnterior = null
        resultadoUltimaOperacion = null
        operacion = ""
    }

    fun pushIgual() {
        var resultadoOperacion: Long = 0
        if (numeroActual != null && numeroAnterior != null){
            when (operacion) {
                "+" -> resultadoOperacion = numeroAnterior!! + numeroActual!!
                "-" -> resultadoOperacion = numeroAnterior!! - numeroActual!!
                "X" -> resultadoOperacion = numeroAnterior!! * numeroActual!!
                "/" ->{
                    if(numeroActual != 0L)  resultadoOperacion = numeroAnterior!! / numeroActual!!
                }
            }
        }
        pushClear()
        numeroAnterior = resultadoOperacion
        resultadoUltimaOperacion = resultadoOperacion.toString()
    }
}
