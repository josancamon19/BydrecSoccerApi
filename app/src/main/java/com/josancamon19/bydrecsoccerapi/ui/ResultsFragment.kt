package com.josancamon19.bydrecsoccerapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.josancamon19.bydrecsoccerapi.R
import com.josancamon19.bydrecsoccerapi.adapters.ResultsListAdapter
import com.josancamon19.bydrecsoccerapi.databinding.FragmentResultsBinding
import com.josancamon19.bydrecsoccerapi.viewmodels.MainActivityViewModel
import com.josancamon19.bydrecsoccerapi.viewmodels.ResultsViewModel
import timber.log.Timber

class ResultsFragment : Fragment() {

    private lateinit var binding: FragmentResultsBinding
    private lateinit var viewModel: ResultsViewModel
    private lateinit var mainViewModel: MainActivityViewModel
    private lateinit var fixturesAdapter: ResultsListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_results, container, false)
        setupRecycler()
        setupViewModel()
        return binding.root
    }

    private fun setupRecycler() {
        binding.resultsRecycler.setHasFixedSize(true)
        fixturesAdapter = ResultsListAdapter()
        binding.resultsRecycler.adapter = fixturesAdapter
        binding.resultsRecycler.addItemDecoration(DividerItemDecoration(context, VERTICAL))
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(ResultsViewModel::class.java)
        viewModel.resultsWithHeaders.observe(this, Observer {
            fixturesAdapter.submitList(it)
        })
        viewModel.pbVisibility.observe(this, Observer {
            when (it) {
                true -> binding.pb.visibility = View.VISIBLE
                false -> binding.pb.visibility = View.GONE
                else -> binding.pb.visibility = View.GONE
            }
        })
        activity?.let {
            mainViewModel = ViewModelProviders.of(it).get(MainActivityViewModel::class.java)
            mainViewModel.competitionSelected.observe(it, Observer { competition ->
                viewModel.filterByCompetition(competition)

            })
        }
        viewModel.competitions.observe(this, Observer {
            mainViewModel.setFilterOptions(it)
        })
    }
}