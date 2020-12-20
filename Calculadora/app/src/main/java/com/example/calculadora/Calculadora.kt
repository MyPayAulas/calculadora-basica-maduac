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

        zero.setOnClickListener { OperacoesParaCalculo("0", true ) }
        um.setOnClickListener { OperacoesParaCalculo("1", true ) }
        dois.setOnClickListener { OperacoesParaCalculo("2", true ) }
        tres.setOnClickListener { OperacoesParaCalculo("3", true ) }
        quatro.setOnClickListener { OperacoesParaCalculo("4", true ) }
        cinco.setOnClickListener { OperacoesParaCalculo("5", true ) }
        seis.setOnClickListener { OperacoesParaCalculo("6", true ) }
        sete.setOnClickListener { OperacoesParaCalculo("7", true ) }
        oito.setOnClickListener { OperacoesParaCalculo("8", true ) }
        nove.setOnClickListener { OperacoesParaCalculo("9", true ) }
        ponto.setOnClickListener { OperacoesParaCalculo(".",true) }
        parentesesEsquerdo.setOnClickListener { OperacoesParaCalculo("(",false) }
        parentesesDireito.setOnClickListener { OperacoesParaCalculo(")",false) }

        soma.setOnClickListener { OperacoesParaCalculo("+", false) }
        subtracao.setOnClickListener { OperacoesParaCalculo("-", false) }
        multiplicacao.setOnClickListener { OperacoesParaCalculo("*",false) }
        divisao.setOnClickListener { OperacoesParaCalculo("/",false) }

        reiniciar.setOnClickListener {
            txtformula.text = ""
            txtresultado.text = ""
        }

        apagar.setOnClickListener {
            val string = txtformula.text

            if (string.isNotBlank()){
                txtformula.text = string.substring(0,string.length-1)
            }
            txtresultado.text = ""
        }

        igual.setOnClickListener {
            try {
                val formula = ExpressionBuilder(txtformula.text.toString()).build()

                val resultado = formula.evaluate()
                val longResultado = resultado.toLong()

                if (resultado==longResultado.toDouble()){
                    txtresultado.text = longResultado.toString()
                }else{
                    txtresultado.text = resultado.toString()
                }
            }catch (e: Exception){
                txtresultado.text = "Inválido"
            }
        }

    }

    //começar o calculo e obtenção de dados
    fun OperacoesParaCalculo(string:String, limpar_dados: Boolean){
        if (txtresultado.text.isNotEmpty()){
            txtformula.text = ""
        }

        if(limpar_dados){
            txtresultado.text = ""
            txtformula.append(string)
        }else{
            txtformula.append(txtresultado.text)
            txtformula.append(string)
            txtresultado.text = ""
        }
    }
}