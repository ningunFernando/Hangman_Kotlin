package com.example.hangman_kotlin

import android.os.Bundle
import android.widget.ImageView
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
private lateinit var hangmanImage: ImageView;

//game state
private lateinit var targetWord: String
private lateinit var currentState: CharArray

//contador de errores
private var mistakes: Int? = 0

private val hangmanStates = listOf(
    R.drawable.hangman0,
    R.drawable.hangman01,
    R.drawable.hangman02,
    R.drawable.hangman03,
    R.drawable.hangman04,
    R.drawable.hangman05,
    R.drawable.hangman06,
)

class GameplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)

        keyboardContainer = findViewById(R.id.gp_keyboardContainer)
        wordText = findViewById(R.id.gp_word)
        hangmanImage = findViewById(R.id.gp_hangmanImage)


        //obtener la palabra y creacion del estado de la palabra con "_"
        targetWord = intent.getStringExtra("WORD")?.uppercase()?: "_ _ _ _ _ _"

        currentState = CharArray(targetWord.length) {'_'}
        RenderWord()

        
        val keys = KeyboardRepository.keys
        for(key in keys){
            val keyView = KeyboardKey(this)
            keyView.bind(key)

            keyView.setOnClickListener {
                onKeyPressed(key.letter, keyView)
            }

            keyboardContainer.addView(keyView)
        }
    }

    //esta funcion muestra el estado actual en el text view
    private fun RenderWord(){
        wordText.text = currentState.joinToString( " ")
    }

    private fun onKeyPressed(letter: Char, keyView: KeyboardKey) {
        val upperLetter = letter.uppercaseChar()
        var found = false

        for(i in targetWord.indices) {
            if (targetWord[i] == upperLetter) {
                currentState[i] = upperLetter
                found = true
            }
        }

        RenderWord()

        keyView.isEnabled = false
        keyView.alpha = 0.5f

        // aquí podrías checar si ya ganó
        if (!currentState.contains('_')) {
            // TODO: mostrar "ganaste"
        }

        // si NO la encontró, aquí iría la lógica de fallos / dibujar ahorcado
        if (!found) {
            // TODO: aumentar contador de errores
        }

    }
}