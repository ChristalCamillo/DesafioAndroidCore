package com.example.desafioandroidcore.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.desafioandroidcore.R
import com.example.desafioandroidcore.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        produtosButton()

        return binding.root
    }

    private fun produtosButton() {
        binding.btProdutos.setOnClickListener {
        }
    }
}