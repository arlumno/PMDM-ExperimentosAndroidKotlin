package com.example.pmdm_experimentosandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmdm_experimentosandroidkotlin.Arflix.Elemento
import com.example.pmdm_experimentosandroidkotlin.databinding.ActivityArflixBinding

class ArflixActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArflixBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityArflixBinding.inflate(layoutInflater);
        setContentView(binding.root)
    }
    var listaElementos = listOf<Elemento>(
                            Elemento("cosa",2),
                            Elemento("cosita",3),
                            Elemento("raton",9),
                            Elemento("botella",12)
                        )
    
}
