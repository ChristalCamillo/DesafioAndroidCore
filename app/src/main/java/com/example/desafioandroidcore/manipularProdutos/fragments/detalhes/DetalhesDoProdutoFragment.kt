package com.example.desafioandroidcore.manipularProdutos.fragments.detalhes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.desafioandroidcore.R
import com.example.desafioandroidcore.databinding.FragmentDetalhesDoProdutoBinding
import com.example.desafioandroidcore.modeloProduto.Produto


class DetalhesDoProdutoFragment : Fragment() {
    private lateinit var binding: FragmentDetalhesDoProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalhesDoProdutoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detalhesProduto()
    }

    private fun detalhesProduto(){
        val produto = arguments?.getParcelable<Produto>(PRODUTO)
        if(produto!= null){

        }
    }

    private fun exibirDetalhes(produto: Produto){
        binding.

    }
}