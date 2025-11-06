package com.example.actividadsuperheroes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.actividadsuperheroes.adapter.NbaAdapter
import com.example.actividadsuperheroes.databinding.ActivityMainBinding
import com.example.actividadsuperheroes.model.Jugadores
import com.example.actividadsuperheroes.providers.Personajes

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter= NbaAdapter(
        Personajes.misPersonajes, { jugadores -> irDetalle(jugadores) },
        { verNombre(it) })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setRecycler()
    }

    private fun setRecycler() {
        val layoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager=layoutManager
        binding.recycler.adapter=adapter
    }
    private fun irDetalle(jugadores: Jugadores){
        val bundle=Bundle().apply {
            putString("NOMBRE", jugadores.nombre)
            putString("DESCRIPCION", jugadores.descripcion)
            putInt("IMAGEN", jugadores.imagen)
        }
        val i = Intent(this, DetalleActivity::class.java)
        i.putExtras(bundle)
        startActivity(i)
    }
    private fun verNombre(nombre: String){
        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
    }
}