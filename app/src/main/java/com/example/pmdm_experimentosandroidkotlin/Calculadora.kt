package com.example.pmdm_experimentosandroidkotlin

import android.util.Log

class Calculadora {
    var numeroActual: Long = 0
    var numeroAnterior: Long = 0
    var tipoOperacion: String = ""
    val maxDigitos = 9

    var textDisplay: String = ""
    var textDisplayMin: String = ""
    val textTipoOperacion: String = "" // anulado


    fun pushNumero(numeroPulsado: Int) {
        if (numeroActual.toString().length < maxDigitos) numeroActual =
            numeroActual * 10 + numeroPulsado.toLong()
        textDisplay = numeroActual as String
        Log.d("::::Ar", "pushNumero $numeroPulsado numeroActual: $numeroActual")
    }

    fun pushPunto() {

    }

    fun pushTipoOperacion(tipoOperacionPulsada: String) {
        tipoOperacion = tipoOperacionPulsada
        numeroAnterior = numeroActual
        textDisplayMin = "$numeroAnterior $tipoOperacion"
        numeroActual = 0
    }


    fun pushClear() {
        numeroActual = 0
        textDisplay = "0"
        numeroAnterior = 0
        textDisplayMin = ""
        tipoOperacion = ""
    }

    fun pushIgual() {
        var resultadoOperacion: Long = 0
        var error = false
        when (tipoOperacion) {
            "+" -> resultadoOperacion = numeroAnterior + numeroActual
            "-" -> resultadoOperacion = numeroAnterior - numeroActual
            "X" -> resultadoOperacion = numeroAnterior * numeroActual
            "/" -> {
                if (numeroActual != 0L) resultadoOperacion =
                    numeroAnterior / numeroActual
                else
                    error = true
            }
        }
        textDisplayMin = "$numeroAnterior $tipoOperacion $numeroActual = "
        if (error){
            pushClear()
            textDisplay = "---ERROR---"
        }else{
            pushClear()
            textDisplay = resultadoOperacion as String
            numeroAnterior = resultadoOperacion

        }
    }
}
