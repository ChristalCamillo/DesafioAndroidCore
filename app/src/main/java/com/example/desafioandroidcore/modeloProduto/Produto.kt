package com.example.desafioandroidcore.modeloProduto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Produto(
    private var nomeDoProduto: String,
    private var qtdDoProduto: Int,
    private var valorUnitarioProduto: Double,
    private var receita: String
) : Parcelable {
    fun getNome() = this.nomeDoProduto
    fun getQtd() = this.qtdDoProduto
    fun getValor() = this.valorUnitarioProduto
    fun getReceita() = this.receita
    fun getValorTotal(qtdDoProduto: Int, valorUnitarioProduto: Double): Double {
        return qtdDoProduto * valorUnitarioProduto
    }
}