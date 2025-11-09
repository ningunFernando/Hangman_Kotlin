package com.example.hangman_kotlin

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hangman_kotlin.data.KeyboardRepository
import com.example.hangman_kotlin.ui.KeyboardKey
import com.google.android.flexbox.FlexboxLayout

private lateinit var wordText: TextView

private lateinit var keyboardContainer: FlexboxLayout

class GameplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)

        keyboardContainer = findViewById(R.id.gp_keyboardContainer)

        wordText = findViewById(R.id.gp_word)

        val word = intent.getStringExtra("WORD: ")?: "______"
        wordText.text =word

        val keys = KeyboardRepository.keys

        for(key in keys){
            val keyView = KeyboardKey(this)
            keyView.bind(key)

            keyView.setOnClickListener { Gameplay() }

            keyboardContainer.addView(keyView)
        }
    }

    private fun Gameplay(){

    }
}