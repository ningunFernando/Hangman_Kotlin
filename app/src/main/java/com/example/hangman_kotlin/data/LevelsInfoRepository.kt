package com.example.hangman_kotlin.data

import com.example.hangman_kotlin.R

object LevelsInfoRepository{
    val levels = listOf(
        levelsInfo(
            imageID = R.drawable.reaction_easy,
            word = "CAFE",
            dificulty = "Easy",
        ),
        levelsInfo(
            imageID = R.drawable.reaction_easy,
             word = "FOTO",
            dificulty = "Easy",
         ),
        levelsInfo(
            imageID = R.drawable.reaction_mid,
            word = "CABALLO",
            dificulty = "Mid",
        ),
        levelsInfo(
            imageID = R.drawable.reaction_mid,
            word = "LAMPARA",
            dificulty = "Mid",
        ),
        levelsInfo(
            imageID = R.drawable.reaction_hard,
            word = "FERROCARRIL",
            dificulty = "Hard",
        ),
        levelsInfo(
            imageID = R.drawable.reaction_mid,
            word = "MURCIELAGO",
            dificulty = "Mid",
        )
    )
}