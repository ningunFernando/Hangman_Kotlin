package com.example.hangman_kotlin.data

object KeyboardRepository {
    val keys = ('A'..'Z').map { letter ->
        keyboardInfo(letter = letter)
    }
}