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
        pushButton(calculadora)

        // botones de 0 al 9
        binding.calc0.setOnClickListener {
            calculadora.pushNumero(0)
            pushButton(calculadora)
        }

        binding.calc1.setOnClickListener {
            calculadora.pushNumero(1)
            pushButton(calculadora)
        }

        binding.calc2.setOnClickListener {
            calculadora.pushNumero(2)
            pushButton(calculadora)
        }

        binding.calc3.setOnClickListener {
            calculadora.pushNumero(3)
            pushButton(calculadora)
        }

        binding.calc4.setOnClickListener {
            calculadora.pushNumero(4)
            pushButton(calculadora)
        }

        binding.calc5.setOnClickListener {
            calculadora.pushNumero(5)
            pushButton(calculadora)
        }

        binding.calc6.setOnClickListener {
            calculadora.pushNumero(6)
            pushButton(calculadora)
        }

        binding.calc7.setOnClickListener {
            calculadora.pushNumero(7)
            pushButton(calculadora)
        }

        binding.calc8.setOnClickListener {
            calculadora.pushNumero(8)
            pushButton(calculadora)
        }

        binding.calc9.setOnClickListener {
            calculadora.pushNumero(9)
            pushButton(calculadora)
        }

        // operaciones
        binding.calcSumar.setOnClickListener {
            calculadora.pushOperacion("+")
            pushButton(calculadora)
        }
        binding.calcRestar.setOnClickListener {
            calculadora.pushOperacion("-")
            pushButton(calculadora)
        }
        binding.calcDividir.setOnClickListener {
            calculadora.pushOperacion("/")
            pushButton(calculadora)
        }
        binding.calcMultiplicar.setOnClickListener {
            calculadora.pushOperacion("X")
            pushButton(calculadora)
        }

        //varios
        binding.calcIgual.setOnClickListener {
            calculadora.pushIgual()
            pushButton(calculadora)
        }
        binding.calcClear.setOnClickListener {
            calculadora.pushClear()
            pushButton(calculadora)
        }

        binding.calcPunto.setOnClickListener {
            Toast.makeText(this,"nada de decimales, de momento es una liada,Not Today...",Toast.LENGTH_SHORT).show()
        }

    }
    fun pushButton(calculadora : Calculadora) {
        Log.d("::::Ar","pushButton")
        binding.calcDisplay.setText(calculadora.numeroDisplay())
        binding.calcDisplayOp.setText(calculadora.operacion)
    }
    fun addNumero(numero: Int, numeroDisplay: Int): Int {
        var resultado: Long = numeroDisplay.toLong() * 10 + numero;
        if (resultado.toString().length > 8) {
            resultado = numeroDisplay.toLong();
        }
        return resultado.toInt();
    }
}

class Calculadora {
    var numero1: Int? = 0
    var numero2: Int = 0
    var operacion: String = ""

    val maxDigitos = 9

    fun pushNumero(numero: Int) {
        var resultado: Long = 0
        Log.d("::::Ar","pushNumero numero: $numero")
        var digitos:Int

        if (numero1.toString().length < maxDigitos) {
            resultado = resultado * 10 + numero
            numero1 =  resultado.toInt();
        }
        Log.d("::::Ar","pushNumero display $numero1")
    }
    fun pushPunto(){

    }

    fun pushOperacion(operacionIn: String) {
//        if(operacion == ""){
            numero2 = numero1 ?: 0
            numero1 = null
//        }
        operacion = operacionIn

    }


    fun numeroDisplay(): String{
        return numero1?.toString() ?: numero2.toString()
    }

    fun pushClear() {
        this.numero1 = 0
        this.numero2 = 0
        this.operacion = ""
    }

    fun pushIgual() {
        var resultado:Long = 0
        when (operacion) {
            "+" -> resultado = (numero1?.toLong() ?: 0) + numero2
            "-" -> resultado = numero2.toLong() + (numero1?:0)
            "X" -> resultado = numero2.toLong() * (numero1?:0)
            "/" -> resultado = numero2.toLong() / (numero1?:0)
        }
        pushClear()
        numero1 = resultado.toInt()
    }
}
