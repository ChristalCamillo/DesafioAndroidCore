package com.example.desafioandroidcore.manipularProdutos.fragments.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroidcore.modeloProduto.Produto
import kotlin.reflect.KFunction1

class ManipularProdutosAdapter(
    private var listaProduto: MutableList<Produto>,
    private var clickProduto: KFunction1<Produto, Unit>,
) : RecyclerView.Adapter<ManipularProdutosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val binding = ProdutoItemBinding.i
    }

    override fun onBindViewHolder(holder: ManipularProdutosAdapter.ViewHolder, position: Int) {
        val produto = listaProduto[position]
        holder.exibirInformacoesView(produto)
        holder.binding.cvItem.setOnClickListener {
            clickProduto(produto)
        }
    }

    override fun getItemCount(): Int {
        return listaProduto.size
    }

    fun atualizarListaProdutos(novaLista: ArrayList<Produto>) {
        if (listaProduto.size == 0) {
            listaProduto = novaLista
        } else if (listaProduto.containsAll(novaLista)) {
        } else {
            listaProduto.addAll(novaLista)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: Bin) : RecyclerView.ViewHolder(binding.root) {
        fun exibirInformacoesView(produto: Produto) {
            binding.tvQntENomeProduto.text = "${produto.getQuantidade()} - ${produto.getNome()}"
        }
    }
}