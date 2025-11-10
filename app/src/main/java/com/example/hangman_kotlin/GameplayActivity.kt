package com.example.hangman_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hangman_kotlin.data.KeyboardRepository
import com.example.hangman_kotlin.ui.KeyboardKey
import com.google.android.flexbox.FlexboxLayout

//GUI
private lateinit var wordText: TextView
private lateinit var keyboardContainer: FlexboxLayout
private lateinit var hangmanImage: ImageView;

//panel de win o lose
private lateinit var resultPanel: LinearLayout
private lateinit var resultText: TextView
private lateinit var backButton: TextView

//game state
private lateinit var targetWord: String
private lateinit var currentState: CharArray

//contador de errores
private var mistakes: Int = 0

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

        //inicializacion de la UI
        keyboardContainer = findViewById(R.id.gp_keyboardContainer)
        wordText = findViewById(R.id.gp_word)
        hangmanImage = findViewById(R.id.gp_hangmanImage)


        resultPanel = findViewById(R.id.gp_resultPanel)
        resultText = findViewById(R.id.gp_resultText)
        backButton = findViewById(R.id.gp_backButton)

        //obtener la palabra y creacion del estado de la palabra con "_" dependiendo del lenght de la misma
        targetWord = intent.getStringExtra("WORD")?.uppercase()?: "_ _ _ _ _ _"
        currentState = CharArray(targetWord.length) {'_'}
        RenderWord()

        hangmanImage.setImageResource(hangmanStates[0])

        //creacion de las teclas del teclado usando las letras de el script KeyRepository
        //cada key llama a onKeyPressed cuando se toca
        val keys = KeyboardRepository.keys
        for(key in keys){
            val keyView = KeyboardKey(this)
            keyView.bind(key)

            keyView.setOnClickListener {
                onKeyPressed(key.letter, keyView)
            }

            keyboardContainer.addView(keyView)
        }

        //se enciende un panel que al dar click nos dejara volver al selector de niveles
        backButton.setOnClickListener { goBackToLevelSelector() }
        resultPanel.setOnClickListener { goBackToLevelSelector() }
    }

    //esta funcion muestra el estado actual en el text view
    private fun RenderWord(){
        wordText.text = currentState.joinToString( " ")
    }

    // se actualiza el gamestate depediendo de una comprobacion si la letra presionada esta en la palabra
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
        keyView.isEnabled = false
        keyView.alpha = 0.5f

        if (!found) {
            mistakes += 1
            updateHangmanImage()
            // si los errores alganzan la cantidad maxima el jugador pierda la cantidad maxima de errores se define por el tamaño del array de imagenes en el hangmanStates
            if(mistakes >= hangmanStates.size-1){
                showResultPanel(false)
                disableKeyboard()
            }
        }
        //si no quedan "_" significa que el player gano el juego
        if(!currentState.contains('_')){
            showResultPanel(true)
            disableKeyboard()
        }
    }

    //actualiza la imgan de el ahorcado dependiendo de la cantidad de errores cometicos
    private fun updateHangmanImage(){
        val index = mistakes.coerceIn(0, hangmanStates.size - 1).toInt()
        hangmanImage.setImageResource(hangmanStates[index])
    }

    //Desactiva todas las teclas del teclado cuando se llama la funcion
    private fun disableKeyboard(){
        for(i in 0 until keyboardContainer.childCount){
            val child = keyboardContainer.getChildAt(i)
            child.isEnabled = false
            child.alpha = 0.5f
        }
    }

    //activa un panel que nos da un mensaje de win o lose dependiendo de si ganamos o perdemos
    private fun showResultPanel(win: Boolean){
        resultPanel.visibility = View.VISIBLE
        resultText.text = if(win) "YOU WIN!!!!" else "YOU LOSE :("
    }

    //reestablece contador de errores a 0 y nos regresa a el level selector despues de dar click a el componente donde se asigne la funcion
    private fun goBackToLevelSelector(){
        mistakes = 0;
        val intent = Intent(this, LevelSelectorActivity::class.java)
        startActivity(intent)
        finish()
    }
}