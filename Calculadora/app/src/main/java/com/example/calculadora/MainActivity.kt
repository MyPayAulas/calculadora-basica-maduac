package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.calculadora.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        inicio.setOnClickListener {
            val intent = Intent(this, Calculadora::class.java)
            startActivity(intent) //Trocar de Activity
            finish() //finalizar MainActivity
        }


    }
}