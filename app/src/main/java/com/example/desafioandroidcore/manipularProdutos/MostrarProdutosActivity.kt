package com.example.desafioandroidcore.manipularProdutos

import PRODUTO
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafioandroidcore.databinding.ActivityMostrarProdutosBinding
import com.example.desafioandroidcore.modeloProduto.Produto

class MostrarProdutosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMostrarProdutosBinding

    private val adapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf(), this::irParaDetalhe)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMostrarProdutosCadastradosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle((R.string.titulo_produtos))

        exibirRecyclerView()
    }

    private fun recuperarAdicionarListaDados() {
        val listaProdutos = ArrayList<Produto>()
        val lista = intent.getParcelableArrayListExtra<Produto>(LISTA_KEY)

        if (lista != null) {
            listaProdutos.addAll(lista)
            adapter.atualizarListaProduto(listaProdutos)
        }
    }

    private fun exibirRecyclerView() {
        recuperarAdicionarListaDados()
        binding..adapter = adapter
        binding.rvProduto.layoutManager = LinearLayoutManager(this)
    }

    private fun irParaDetalhe(produto: Produto) {
        val intent = Intent(this, DetalhesProdutoActivity::class.java).apply {
            putExtra(PRODUTO, produto)
        }
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}