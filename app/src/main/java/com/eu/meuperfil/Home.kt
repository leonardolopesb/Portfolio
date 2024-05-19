package com.eu.meuperfil

import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.eu.meuperfil.adapter.AdapterLista
import com.eu.meuperfil.databinding.ActivityHomeBinding
import com.eu.meuperfil.model.Lista
import androidx.fragment.app.Fragment
import com.eu.meuperfil.view.HomeFragment
import com.eu.meuperfil.view.Profile

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inflando o layout padrão de tela
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        //Tirando a cor roxa da parte superior do app
        window.statusBarColor = Color.parseColor("#232323")

        //supportActionBar?.hide()

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.ic_home -> replaceFragment(HomeFragment())
                R.id.ic_profile -> replaceFragment(Profile())

                else -> true
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}