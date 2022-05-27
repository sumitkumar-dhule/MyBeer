package com.sample.mybeer.presentation.beer_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.sample.mybeer.R
import com.sample.mybeer.databinding.FragmentBeerDetailBinding
import com.sample.mybeer.databinding.FragmentBeerListBinding
import com.sample.mybeer.presentation.adapter.BeerAdapter
import com.sample.mybeer.presentation.beer_list.BeerListState
import com.sample.mybeer.presentation.beer_list.BeerListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
@AndroidEntryPoint
class BeerDetailFragment : Fragment() {

//    private var _binding: FragmentBeerDetailBinding? = null

    private val viewModel by viewModels<BeerDetailViewModel>()

    // This property is only valid between onCreateView and
    // onDestroyView.
//    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentBeerDetailBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel


//        _binding = binding

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
//
//            viewModel.state.collect() { value: BeerDetailState ->
//
//                binding.tvBeerDescription.text = value.beer?.description
//
//            }
//        }
//

    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}