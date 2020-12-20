package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_historico.*

class HistoricoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)
        supportActionBar!!.hide()

        val listaCalculos = intent.getParcelableExtra<HistoricoCalculos>("historico")
        val arrayCalculos: Array<String>? = listaCalculos?.listaCalculos?.map { it.toString() }?.toTypedArray()
        val adapterCalculos = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayCalculos!!)

        lvCalculos.adapter = adapterCalculos

        lvCalculos.setOnItemClickListener { parent, view, position, _ ->
            val txt = (view as TextView).text
            Toast.makeText(this, txt, Toast.LENGTH_SHORT).show()
        }
    }
}