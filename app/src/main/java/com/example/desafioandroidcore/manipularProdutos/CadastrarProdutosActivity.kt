package com.example.desafioandroidcore.manipularProdutos

import PRODUTO
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.desafioandroidcore.databinding.ActivityCadastrarProdutosBinding
import com.example.desafioandroidcore.modeloProduto.Produto

class CadastrarProdutosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastrarProdutosBinding
    private lateinit var nome : String
    private lateinit var qntd : String
    private lateinit var valorUni : String
    private lateinit var receita : String
    private val listaProdutos = ArrayList<Produto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Produtos"

        binding.btCadastrarNovoProduto.setOnClickListener {
            adicionarListaDados()
        }

        binding.btVerProdutos.setOnClickListener {
            if (listaProdutos.isNotEmpty()){
                MostrarProdutosCadastrados(enviarDados())
            }
        }
    }

    private fun enviarDados(): Produto? {
        return if (!verificarCamposEdicao()){
            val produto = Produto(nome, qntd, valorUni, receita )
            Toast.makeText(this,"Produto cadastrado com sucesso", Toast.LENGTH_LONG).show()
            limparEdicao()

            produto
        } else {
            null
        }
    }

    private fun recuperarDados(){
        nome = binding.etNomeProduto.text.toString()
        qntd = binding.etQuantidadeProduto.text.toString()
        valorUni = binding.etValorUnitario.text.toString()
        receita = binding.etReceita.text.toString()
    }

    private fun adicionarListaDados() {
        recuperarDados()
        val produto = enviarDados()

        if (produto != null) {
            listaProdutos.add(produto)
        }
    }

    private fun verificarCamposEdicao(
    ): Boolean {
        when {
            this.nome.isBlank() -> {
                binding.etNomeProduto.error = "Insira o nome do produto!"
                return true
            }
            this.qntd.isBlank() -> {
                binding.etQuantidadeProduto.error = "Insira um valor!"
                return true
            }
            this.valorUni.isBlank() -> {
                binding.etValorUnitario.error = "Insira um valor!"
                return true
            }
            this.receita.isBlank() -> {
                binding.etReceita.error = "Insira uma receita!"
                return true
            }
        }
        return false
    }

    private fun limparEdicao() {
        binding.etNomeProduto.text.clear()
        binding.etQuantidadeProduto.text.clear()
        binding.etValorUnitario.text.clear()
        binding.etReceita.text.clear()
    }

    private fun MostrarProdutosCadastrados(produto: Produto?) {
        val intent = Intent(this, MostrarProdutosActivity::class.java).apply {
            putExtra(PRODUTO, produto)
            putParcelableArrayListExtra(PRODUTO,listaProdutos)
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