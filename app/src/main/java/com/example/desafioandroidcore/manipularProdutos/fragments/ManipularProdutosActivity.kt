package com.example.desafioandroidcore.manipularProdutos.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.desafioandroidcore.databinding.ActivityManipularProdutosBinding

class ManipularProdutosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManipularProdutosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManipularProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        produtosActionBar()
    }

    private fun produtosActionBar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Produtos")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}