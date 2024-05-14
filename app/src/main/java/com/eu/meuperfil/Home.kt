package com.eu.meuperfil

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eu.meuperfil.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Tirando a cor roxa da parte superior do app
        window.statusBarColor = Color.parseColor("#232323")

        //Inflando o layout padrão de tela
        var binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
    }
}