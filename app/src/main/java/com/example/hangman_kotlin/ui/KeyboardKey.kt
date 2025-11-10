package com.example.hangman_kotlin.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.example.hangman_kotlin.R
import com.example.hangman_kotlin.data.keyboardInfo

//Custom view que representa una tecla del teclado custom, su unico atributo es la letra que tendra como valor
class KeyboardKey @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {
    //referencias a los componentes del layout
    private val kb_KeyText: TextView
    //se agrega el xml a la custom view y buscamos id's de los componentes
    init {
        LayoutInflater.from(context).inflate(R.layout.keyboard_key, this, true)

        kb_KeyText = findViewById(R.id.kb_KeyText)
    }

    fun bind(keyboardInfo: keyboardInfo){
        kb_KeyText.text = keyboardInfo.letter.toString();
    }
}