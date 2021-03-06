package com.sample.mybeer.presentation.beer_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.sample.mybeer.databinding.FragmentBeerDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BeerDetailFragment : Fragment() {

    private val viewModel by viewModels<BeerDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentBeerDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

}