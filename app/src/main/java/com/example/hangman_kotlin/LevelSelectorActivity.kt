package com.example.hangman_kotlin

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hangman_kotlin.data.LevelsInfoRepository
import com.example.hangman_kotlin.ui.LevelCardView

private lateinit var levelsContainer: LinearLayout

class LevelSelectorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_selector)

        levelsContainer = findViewById(R.id.lsa_LevelsContainer)

        val levels = LevelsInfoRepository.levels

        for(level in levels){
            val levelView = LevelCardView(this)
            levelView.bind(level)
            levelsContainer.addView(levelView)
        }
    }
}