package com.example.pmdm_experimentosandroidkotlin

import android.util.Log

class Calculadora {
    var numeroActual: Long = 0
    var numeroAnterior: Long = 0
    var resultadoOperacion: Long? = null
    var tipoOperacion: String = ""
    val maxDigitos = 9

    var textDisplay: String = ""
    var textDisplayMin: String = ""
    val textTipoOperacion: String = "" // anulado


    fun pushNumero(numeroPulsado: Int) {
        if (numeroActual.toString().length < maxDigitos) numeroActual =
            numeroActual * 10 + numeroPulsado.toLong()
        textDisplay = numeroActual.toString()
        resultadoOperacion?.let { resultadoOperacion = null }

        Log.d("::::Ar", "pushNumero() -> numeroActual $numeroActual numeroAnterior: $numeroAnterior  resultadoOperacion $resultadoOperacion?")
    }

    fun pushPunto() {
        //TODO
    }

    fun pushDel() {
        numeroActual = numeroActual / 10
        textDisplay = numeroActual.toString()
    }
    fun pushTipoOperacion(tipoOperacionPulsada: String) {

        if (tipoOperacion == "") {
            resultadoOperacion?.let {
                numeroAnterior = it
                resultadoOperacion = null
            } ?: run {
                numeroAnterior = numeroActual
                numeroActual = 0
            }
            // en lugar de:
//            if(resultadoOperacion != null) {
//                numeroAnterior = resultadoOperacion!!
//                resultadoOperacion = null
//            } else {
//                numeroAnterior = numeroActual
//                numeroActual = 0
//            }
            Log.d("::::Ar", "pushTipoOperacion() -> numeroActual $numeroActual numeroAnterior: $numeroAnterior  resultadoOperacion $resultadoOperacion?")
        }

        tipoOperacion = tipoOperacionPulsada
        textDisplayMin = "$numeroAnterior $tipoOperacion"

    }


    fun pushClear() {
        numeroActual = 0
        textDisplay = "0"
        numeroAnterior = 0
        textDisplayMin = ""
        tipoOperacion = ""
    }

    fun pushIgual() {
        var error = false
        resultadoOperacion = null;
        if(tipoOperacion != ""){

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
        var aux = "$numeroAnterior $tipoOperacion $numeroActual = "
        pushClear()
        if (error) {
            textDisplay = "--- ERROR ---"
        } else {
            resultadoOperacion?.let {
                textDisplay = it.toString()
            }
        }
        textDisplayMin = aux

        Log.d("::::Ar", "pushIgual() -> numeroActual $numeroActual numeroAnterior: $numeroAnterior  resultadoOperacion $resultadoOperacion")
        }

    }
}
