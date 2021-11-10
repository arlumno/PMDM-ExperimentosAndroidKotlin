package com.example.pmdm_experimentosandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmdm_experimentosandroidkotlin.ClasesArflix.elemento
import com.example.pmdm_experimentosandroidkotlin.databinding.ActivityArflixBinding

class ArflixActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArflixBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityArflixBinding.inflate(layoutInflater);
        setContentView(binding.root)
    }
    var listaElementos = listOf<elemento>(
                            elemento("cosa",2),
                            elemento("cosita",3),
                            elemento("raton",9),
                            elemento("botella",12)
                        )
    
}
