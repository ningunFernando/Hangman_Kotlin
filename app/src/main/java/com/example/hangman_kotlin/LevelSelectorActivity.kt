package com.example.hangman_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.hangman_kotlin.data.LevelsInfoRepository
import com.example.hangman_kotlin.ui.LevelCardView

private lateinit var levelsContainer: LinearLayout

class LevelSelectorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_selector)

        levelsContainer = findViewById(R.id.lsa_LevelsContainer)

        //se obtiene la lista de niveles definida en LevelsInfoRepository
        val levels = LevelsInfoRepository.levels

        //por cada elemento en  la lista de LevelsInfoRepository se crea un LevelCardView y se agrega a levelsContainer
        for(level in levels){
            val levelView = LevelCardView(this)
            levelView.bind(level)

            //al hacer click en la carta se inicia la GameplayActivity
            //y se le pasa la palabra correspondiente como parámetro
            levelView.setOnClickListener {
                val intent = Intent(this, GameplayActivity::class.java)
                intent.putExtra("WORD", level.word)
                startActivity(intent)
            }

            levelsContainer.addView(levelView)
        }
    }
}