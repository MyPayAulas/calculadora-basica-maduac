package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_historico.*

class HistoricoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)

        supportActionBar!!.hide()

        var historicoStr = """
            ${intent.getStringExtra("cabecalho")}
        """.trimIndent()

        intent.getParcelableExtra<HistoricoCalculos>("historico")?.listaCalculos?.map {
            historicoStr += "\n${it.expressao} = ${it.resultado}"
        }

        txtPrint.text = historicoStr

    }
}