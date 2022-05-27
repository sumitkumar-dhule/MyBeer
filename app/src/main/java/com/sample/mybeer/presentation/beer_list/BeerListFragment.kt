package com.sample.mybeer.presentation.beer_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.sample.mybeer.R
import com.sample.mybeer.common.Constants
import com.sample.mybeer.databinding.FragmentBeerListBinding
import com.sample.mybeer.presentation.adapter.BeerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class BeerListFragment : Fragment() {

    private var _binding: FragmentBeerListBinding? = null


    private val TAG = this.javaClass.simpleName
    private val viewModel by viewModels<BeerListViewModel>()
    private lateinit var beerAdapter: BeerAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentBeerListBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        beerAdapter = BeerAdapter()
        binding.rvBeers.adapter = beerAdapter

        _binding = binding

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        beerAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putString(Constants.PARAM_BEER_ID, it.id.toString())
            }
            findNavController().navigate(
                R.id.action_FirstFragment_to_SecondFragment,
                bundle
            )

        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {

            viewModel.state.collect() { value: BeerListState ->

                value.beers.let {
                    beerAdapter.differ.submitList(it)
                }


            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}