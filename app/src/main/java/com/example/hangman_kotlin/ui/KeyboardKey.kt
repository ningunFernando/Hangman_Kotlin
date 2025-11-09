package com.example.hangman_kotlin.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.example.hangman_kotlin.R
import com.example.hangman_kotlin.data.keyboardInfo


class KeyboardKey @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private val kb_KeyText: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.keyboard_key, this, true)

        kb_KeyText = findViewById(R.id.kb_KeyText)
    }

    fun bind(keyboardInfo: keyboardInfo){
        kb_KeyText.text = keyboardInfo.letter.toString();
    }
}