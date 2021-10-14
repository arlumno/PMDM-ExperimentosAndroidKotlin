package com.example.pmdm_experimentosandroidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val calcSalir = findViewById<Button>(R.id.calcSalir)


        var numeroDisplay = 0
        // declaramos botones
        val calc0 = findViewById<Button>(R.id.calc0)
        val calc1 = findViewById<Button>(R.id.calc1)
        val calc2 = findViewById<Button>(R.id.calc2)
        val calc3 = findViewById<Button>(R.id.calc3)
        val calc4 = findViewById<Button>(R.id.calc4)
        val calc5 = findViewById<Button>(R.id.calc5)
        val calc6 = findViewById<Button>(R.id.calc6)
        val calc7 = findViewById<Button>(R.id.calc7)
        val calc8 = findViewById<Button>(R.id.calc8)
        val calc9 = findViewById<Button>(R.id.calc9)

        val calcDividir = findViewById<Button>(R.id.calcDividir)
        val calcMultiplicar = findViewById<Button>(R.id.calcMultiplicar)
        val calcIgual = findViewById<Button>(R.id.calcIgual)
        val calcDisplay = findViewById<TextView>(R.id.calcDisplay)
        var operador1:Int = 0
        var operador2:Int = 0
        var operacion:String = ""
        var resultado:Long

        calc0.setOnClickListener {
            if(numeroDisplay != 0){
                numeroDisplay = addNumero(0, numeroDisplay)
                calcDisplay.setText(numeroDisplay.toString())
            }
        }

        calc1.setOnClickListener {
            numeroDisplay = addNumero(1, numeroDisplay)
            calcDisplay.setText(numeroDisplay.toString())
        }

        calc2.setOnClickListener {
            numeroDisplay = addNumero(2, numeroDisplay)
            calcDisplay.setText(numeroDisplay.toString())
        }

        calc3.setOnClickListener {
            numeroDisplay = addNumero(3, numeroDisplay)
            calcDisplay.setText(numeroDisplay.toString())
        }

        calc4.setOnClickListener {
            numeroDisplay = addNumero(4, numeroDisplay)
            calcDisplay.setText(numeroDisplay.toString())
        }

        calc5.setOnClickListener {
            numeroDisplay = addNumero(5, numeroDisplay)
            calcDisplay.setText(numeroDisplay.toString())
        }

        calc6.setOnClickListener {
            numeroDisplay = addNumero(6, numeroDisplay)
            calcDisplay.setText(numeroDisplay.toString())
        }

        calc7.setOnClickListener {
            numeroDisplay = addNumero(7, numeroDisplay)
            calcDisplay.setText(numeroDisplay.toString())
        }

        calc8.setOnClickListener {
            numeroDisplay = addNumero(8, numeroDisplay)
            calcDisplay.setText(numeroDisplay.toString())
        }

        calc9.setOnClickListener {
            numeroDisplay = addNumero(9, numeroDisplay)
            calcDisplay.setText(numeroDisplay.toString())
        }
        findViewById<Button>(R.id.calcClear).setOnClickListener{
            numeroDisplay = 0
            calcDisplay.setText("0")
        }
        findViewById<Button>(R.id.calcSumar).setOnClickListener{
//            operador1 = numeroDisplay
//            numeroDisplay = 0
//            calcDisplay.setText(0)
//            operacion = "sumar"
            Toast.makeText(this.applicationContext, "Sumando", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.calcIgual).setOnClickListener{
            operador2 = numeroDisplay
            when (operacion){
                "sumar" -> calcDisplay.setText(operador1+operador2);
            }
            operador1 = 0
            operador2 = 0

        }

    }

    fun addNumero(numero: Int, numeroDisplay: Int): Int {
        var resultado: Long = numeroDisplay.toLong() * 10 + numero;
        if(resultado.toString().length  > 8){
            resultado = numeroDisplay.toLong();
        }
        return resultado.toInt();
    }
}