package com.example.actividadsuperheroes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.actividadsuperheroes.R
import com.example.actividadsuperheroes.model.Jugadores

class NbaAdapter(private val lista: ArrayList<Jugadores>, private val onDetalleClick: (Jugadores)->Unit, private val
onHolderClick: (String)->Unit): RecyclerView.Adapter<NbaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NbaViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.jugadores_layout, parent, false)
        return NbaViewHolder(v)
    }
    override fun getItemCount()=lista.size
    override fun onBindViewHolder(holder: NbaViewHolder, position: Int) {
        val personaje=lista[position]
        holder.render(personaje, onDetalleClick, onHolderClick)
    }
}