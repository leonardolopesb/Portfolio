package com.eu.meuperfil.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eu.meuperfil.databinding.ListaItemBinding
import com.eu.meuperfil.model.Lista

class AdapterLista(private val context: Context, private val RecyclerViewLista: MutableList<Lista>):
    RecyclerView.Adapter<AdapterLista.ListaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        //Para criar itens à lista
        val itemLista = ListaItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ListaViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        //Para mostrar a lista
        holder.txtNome.text = RecyclerViewLista[position].nome
    }

    override fun getItemCount() = RecyclerViewLista.size
    //Para mostrar os itens da lista

    inner class ListaViewHolder(binding: ListaItemBinding): RecyclerView.ViewHolder(binding.root){
        val txtNome = binding.txtLista
    }
}