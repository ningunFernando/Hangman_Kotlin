package com.example.hangman_kotlin.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.hangman_kotlin.R
import com.example.hangman_kotlin.data.levelsInfo

//Custom view que representa una carta/nivel en el selector de niveles
//se encarga de mostrar la info de un nivel: dificultad, palabra, largo e imagen
class LevelCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
    ) : LinearLayout(context, attrs, defStyle) {

        //referencias a los componentes del layout
        private val cv_dificulty:  TextView
        private val  cv_word: TextView
        private val cv_lenght: TextView
        private val cv_image: ImageView

    //se agrega el xml a la custom view y buscamos id's de los componentes
    init{
        LayoutInflater.from(context).inflate(R.layout.sample_level_card_view, this, true)

        cv_dificulty = findViewById(R.id.cv_dificulty)
        cv_word = findViewById(R.id.cv_word)
        cv_lenght = findViewById(R.id.cv_lenght)
        cv_image = findViewById(R.id.cv_image)
    }

    //se recibe un objeto de tipo levelsinfo que contiene la informacion para poder generar diferentes cards para niveles
    fun bind(levelsInfo: levelsInfo){
        cv_dificulty.text = "Dificulty: ${levelsInfo.dificulty}"
        cv_word.text = levelsInfo.word
        cv_lenght.text = "Lenght: ${levelsInfo.length}"
        cv_image?.setImageResource(levelsInfo.imageID)

    }


}


//no habia asistido a clase y no vi lo del recicle view asi que use lo que conozco mas de dsarollo web y soluciones con componentes
//que ya habia usado en flutter asi que use chat gpt para que ver si habia algo similar en kotlin y encontre las custom views
/*
class CustomCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private val tvTitle: TextView
    private val tvSubtitle: TextView

    init {
        // inflar el layout dentro del CustomView
        LayoutInflater.from(context).inflate(R.layout.view_card, this, true)

        tvTitle = findViewById(R.id.tvTitle)
        tvSubtitle = findViewById(R.id.tvSubtitle)

        orientation = VERTICAL
    }

    // método público para setear datos
    fun setData(title: String, subtitle: String) {
        tvTitle.text = title
        tvSubtitle.text = subtitle
    }
}
* */