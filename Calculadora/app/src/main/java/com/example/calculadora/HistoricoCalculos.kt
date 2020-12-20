package com.example.calculadora

import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
class HistoricoCalculos(var listaCalculos: MutableList<Calculo>):Parcelable