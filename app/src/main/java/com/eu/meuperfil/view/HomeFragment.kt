package com.eu.meuperfil.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.eu.meuperfil.adapter.AdapterLista
import com.eu.meuperfil.databinding.FragmentHomeBinding
import com.eu.meuperfil.model.Lista

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val lista: MutableList<Lista> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val recyclerViewLista = binding.RecyclerViewLista
        recyclerViewLista.layoutManager = LinearLayoutManager(requireContext())

        val adapterLista = AdapterLista(requireContext(), lista)
        recyclerViewLista.setHasFixedSize(true)

        recyclerViewLista.adapter = adapterLista

        nomes()

        return binding.root
    }

    private fun nomes() {
        val item1 = Lista("João Marcos")
        lista.add(item1)

        val item2 = Lista("Sinclair")
        lista.add(item2)

        val item3 = Lista("Leonardo")
        lista.add(item3)

        val item4 = Lista("Fabrício")
        lista.add(item4)

        val item5 = Lista("Marcos")
        lista.add(item5)

        val item6 = Lista("Carlos")
        lista.add(item6)

        val item7 = Lista("Guilherme")
        lista.add(item7)

        val item8 = Lista("Samuel")
        lista.add(item8)

        val item9 = Lista("Pedro")
        lista.add(item9)

        val item10 = Lista("Eduardo")
        lista.add(item10)
    }
}