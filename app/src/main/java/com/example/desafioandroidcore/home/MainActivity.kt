package com.example.desafioandroidcore.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafioandroidcore.R
import com.example.desafioandroidcore.databinding.ActivityMainBinding
import com.example.desafioandroidcore.manipularProdutos.fragments.ManipularProdutosActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle("SimCity São João")

        botaoIrParaProdutos(cadastroProdutos())
    }

    private fun botaoIrParaProdutos(intent: Intent){
        binding.btProdutos.setOnClickListener { startActivity(intent) }
    }

    private fun cadastroProdutos() = Intent(this, ManipularProdutosActivity::class.java)
}