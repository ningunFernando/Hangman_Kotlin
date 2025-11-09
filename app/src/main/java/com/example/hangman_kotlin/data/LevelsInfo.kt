package com.example.hangman_kotlin.data

data class LevelsInfo(
    val imageID: Int,
    val word: String,
    val dificulty: String
){
    val length: Int get() = word.length
}