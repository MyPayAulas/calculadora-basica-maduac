package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_historico_customizada.*

class HistoricoActivityCustomizada : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico_customizada)
        supportActionBar!!.hide()

        val listaCalculos = intent.getParcelableExtra<HistoricoCalculos>("historico")?.listaCalculos

        if(listaCalculos != null) {
            lvHistoricoCustomizado.adapter = CalculosAdapter(this, listaCalculos)
        }
    }
}