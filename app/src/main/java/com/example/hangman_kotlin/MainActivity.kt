package com.example.hangman_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//declaramos las views a las cuales necesitamos acceder a alguna de sus propiedades en nuestro layout
private lateinit var homePanel: LinearLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        homePanel = findViewById(R.id.main)
        homePanel.setOnClickListener { onClickSendToLevelSelector() }
    }
    //funcion que llama a inciar la actividad de level selector
    private fun onClickSendToLevelSelector(){
        startActivity(Intent(this, LevelSelectorActivity::class.java))
        print("Si funciona")
    }
}