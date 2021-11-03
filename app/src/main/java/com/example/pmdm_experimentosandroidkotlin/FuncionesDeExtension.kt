package com.example.pmdm_experimentosandroidkotlin

import android.app.Activity
import android.widget.Toast

fun Activity.mostrarToast(mensaje: String, duracion: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,mensaje,duracion).show();
}