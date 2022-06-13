package com.example.desafioandroidcore.produto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.desafioandroidcore.R
import com.example.desafioandroidcore.databinding.FragmentProdutosBinding

class produtosFragment : Fragment() {
    private lateinit var binding: FragmentProdutosBinding

    //inicializar lista vazia
    private val produtoAdapter: produtoAdapter by Lazy
}