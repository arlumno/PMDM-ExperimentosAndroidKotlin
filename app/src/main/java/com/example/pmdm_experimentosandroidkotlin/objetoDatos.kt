package com.example.pmdm_experimentosandroidkotlin

import android.view.View
import android.widget.Button
import android.widget.TextView

object objetoDatos {
     var clicks: Int = 0
     private var log:String = ""
     fun log(v: View){
         when(v){
             v as TextView ->log += "TextView: " + v.getText();
             v as Button ->log += "Boton: " + v.text;
             else -> log += "?? " + v.typeface + " : "+ v.text;
         }
     }
 }

