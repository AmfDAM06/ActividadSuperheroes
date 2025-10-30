package com.example.actividadsuperheroes.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.actividadsuperheroes.databinding.JugadoresLayoutBinding
import com.example.actividadsuperheroes.model.Jugadores

class NbaViewHolder(v: View): RecyclerView.ViewHolder(v) {
    val binding = JugadoresLayoutBinding.bind(v)
    fun render(
        personaje: Jugadores,
        onDetalleClick: (Jugadores) -> Unit,
        onHolderClick: (String) -> Unit
    ) {
        binding.tvNombre.text = personaje.nombre
        binding.imageView.setImageResource(personaje.imagen)
        binding.btnDetalle.setOnClickListener {
            onDetalleClick(personaje)
        }
        itemView.setOnClickListener {
            onHolderClick(personaje.nombre)
        }
    }
}
