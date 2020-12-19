package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.calculadora.*

class Calculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculadora)

        supportActionBar!!.hide() //Esconder toolbar

        zero.setOnClickListener { CalculoIncial("0", true ) }
        um.setOnClickListener { CalculoIncial("1", true ) }
        dois.setOnClickListener { CalculoIncial("2", true ) }
        tres.setOnClickListener { CalculoIncial("3", true ) }
        quatro.setOnClickListener { CalculoIncial("4", true ) }
        cinco.setOnClickListener { CalculoIncial("5", true ) }
        seis.setOnClickListener { CalculoIncial("6", true ) }
        sete.setOnClickListener { CalculoIncial("7", true ) }
        oito.setOnClickListener { CalculoIncial("8", true ) }
        nove.setOnClickListener { CalculoIncial("9", true ) }
    }

    //começar o calculo e obtenção de dados
    fun CalculoIncial(string:String, limpar_dados: Boolean){
        if (resultado.text.isNotEmpty()){
            formula.text = ""
        }

        if(limpar_dados){
            resultado.text = ""
            formula.append(string)
        }else{
            formula.append(resultado.text)
            formula.append(string)
            resultado.text = ""
        }
    }
}