package com.example.hangman_kotlin.data

import com.example.hangman_kotlin.R

object LevelsInfoRepository{
    val levels = listOf(
        LevelsInfo(
            imageID = R.drawable.reaction_easy,
            word = "CAFE",
            dificulty = "Easy",
        ),
        LevelsInfo(
            imageID = R.drawable.reaction_easy,
             word = "FOTO",
            dificulty = "Easy",
         ),
        LevelsInfo(
            imageID = R.drawable.reaction_mid,
            word = "CABALLO",
            dificulty = "Mid",
        ),
        LevelsInfo(
            imageID = R.drawable.reaction_mid,
            word = "LAMPARA",
            dificulty = "Mid",
        ),
        LevelsInfo(
            imageID = R.drawable.reaction_hard,
            word = "FERROCARRIL",
            dificulty = "Hard",
        )
    )
}