package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.calculadora.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

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
        ponto.setOnClickListener { CalculoIncial(".",true) }

        soma.setOnClickListener { CalculoIncial("+", false) }
        subtracao.setOnClickListener { CalculoIncial("-", false) }
        multiplicacao.setOnClickListener { CalculoIncial("*",false) }
        divisao.setOnClickListener { CalculoIncial("/",false) }

        reiniciar.setOnClickListener {
            formula.text = ""
            resultadofinal.text = ""
        }

        apagar.setOnClickListener {
            val string = formula.text.toString()

            if (string.isNotBlank()){
                formula.text = string.substring(0,string.length-1)
            }
            resultadofinal.text = ""
        }

        igual.setOnClickListener {
            try {
                val formula = ExpressionBuilder(formula.text.toString()).build()

                val resultado = formula.evaluate()
                val longResultado = resultado.toLong()

                if (resultado==longResultado.toDouble()){
                    resultadofinal.text = longResultado.toString()
                }else{
                    resultadofinal.text = resultado.toString()
                }
            }catch (e: Exception){

            }
        }

    }

    //começar o calculo e obtenção de dados
    fun CalculoIncial(string:String, limpar_dados: Boolean){
        if (resultadofinal.text.isNotEmpty()){
            formula.text = ""
        }

        if(limpar_dados){
            resultadofinal.text = ""
            formula.append(string)
        }else{
            formula.append(resultadofinal.text)
            formula.append(string)
            resultadofinal.text = ""
        }
    }
}