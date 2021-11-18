package com.example.pmdm_experimentosandroidkotlin

import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.pmdm_experimentosandroidkotlin.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.io.File
import java.nio.file.Files

class ClickerTracker {
    var clicks: Int = 0
    private var log:String = ""
    lateinit var clicker: TextView
    //clicker.setText(objetodatos.clicks.toString())

//    binding.root.setOnClickListener {
//        track()
//    }
    fun start(act: Activity, l: LinearLayout){
        clicker = TextView(act, null, R.style.clickerStyle, R.style.clickerStyle)
        clicker.setText(clicks.toString())
        l.addView(clicker)
    }

    fun track(act: Activity, v: View) {
        clicks++
        //act.mostrarToast("click")
        act.mostrarToast(clicks.toString())
        clicker.text = clicks.toString()

        log(v)
        //act.mostrarToast(log)
        //MaterialAlertDialogBuilder(act).setMessage(log).show()
    }

    fun mostrarLog(act: Activity){
        MaterialAlertDialogBuilder(act).setMessage(log).show()
    }

    fun log(v: View){
        when(v){
            is Button -> log += "Botón: "
           is TextView -> log += "TextView:"
            else -> log += (v::class.java)
        }
        log +=  " Id: " + v.getResources().getResourceEntryName(v.getId())
        //log +=  "Package: " + v.getResources().getResourcePackageName(v.getId()) + "\n"
        //log += "\n"
        val archivo = File("com/example/pmdm_experimentosandroidkotlin/res/archivosRaros/log.txt")
        Log.d(":::Ar", archivo.exists().toString())
        //archivo.appendText("\n $log")
     //   val oS = archivo.printWriter().use { out -> out.println(log) }

    }
}