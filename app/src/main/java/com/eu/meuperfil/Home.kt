package com.eu.meuperfil

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.eu.meuperfil.adapter.AdapterLista
import com.eu.meuperfil.databinding.ActivityHomeBinding
import com.eu.meuperfil.model.Lista

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapterLista: AdapterLista
    private val lista: MutableList<Lista> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inflando o layout padrão de tela
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Tirando a cor roxa da parte superior do app
        window.statusBarColor = Color.parseColor("#232323")

        supportActionBar?.hide()

        val recyclerViewLista = binding.RecyclerViewLista

        recyclerViewLista.layoutManager = LinearLayoutManager(this)
        recyclerViewLista.setHasFixedSize(true)

        adapterLista = AdapterLista(this, lista)

        recyclerViewLista.adapter = adapterLista

        nomes()
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