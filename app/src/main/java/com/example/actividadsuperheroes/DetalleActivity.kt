package com.example.actividadsuperheroes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.actividadsuperheroes.databinding.ActivityDetalleBinding
import com.example.actividadsuperheroes.model.Jugadores
import kotlin.toString

class DetalleActivity: AppCompatActivity() {
    private lateinit var binding: ActivityDetalleBinding
    private lateinit var personaje: Jugadores
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setListener()
        cogerDatos()
        pintarPersonaje()
    }

    private fun setListener() {
        binding.btnVolver.setOnClickListener { finish() }
    }
    //-----------------------------------------------------------------------------------------------
    private fun cogerDatos() {
        val datos = intent.extras
        val nombre=datos?.getString("NOMBRE").toString()
        val descripcion=datos?.getString("DESCRIPCION").toString()
        val imagen=datos?.getInt("IMAGEN")?:0
        personaje= Jugadores(nombre, descripcion, imagen)
    }
    //----------------------------------------------------------------------------------------------
    private fun pintarPersonaje() {
        binding.tvNombreDetalle.text=personaje.nombre
        binding.tvDescripcion.text=personaje.descripcion
        binding.ivDetalle.setImageResource(personaje.imagen)
    }
}