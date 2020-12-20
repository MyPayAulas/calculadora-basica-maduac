package com.example.calculadora

import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class Calculo(val expressao: String, val resultado: String): Parcelable {
    override fun toString(): String {
        return "$expressao = $resultado"
    }
}