package com.josancamon19.bydrecsoccerapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.josancamon19.bydrecsoccerapi.R
import com.josancamon19.bydrecsoccerapi.adapters.FixturesListAdapter
import com.josancamon19.bydrecsoccerapi.databinding.FragmentFixturesBinding
import com.josancamon19.bydrecsoccerapi.viewmodels.FixturesViewModel
import com.josancamon19.bydrecsoccerapi.viewmodels.MainActivityViewModel

class FixturesFragment : Fragment() {

    private lateinit var binding: FragmentFixturesBinding
    private lateinit var viewModel: FixturesViewModel
    private lateinit var mainViewModel: MainActivityViewModel
    private lateinit var fixturesAdapter: FixturesListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fixtures, container, false)
        setupRecycler()
        setupViewModel()
        return binding.root
    }

    private fun setupRecycler() {
        binding.fixturesRecycler.setHasFixedSize(true)
        fixturesAdapter = FixturesListAdapter()
        binding.fixturesRecycler.adapter = fixturesAdapter
        binding.fixturesRecycler.addItemDecoration(DividerItemDecoration(context, VERTICAL))

    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(FixturesViewModel::class.java)
        viewModel.fixturesWithHeaders.observe(this, Observer {
            fixturesAdapter.submitList(it)
        })
        viewModel.pbVisibility.observe(this, Observer {
            when (it) {
                true -> binding.pb.visibility = VISIBLE
                false -> binding.pb.visibility = GONE
                else -> binding.pb.visibility = GONE
            }
        })
        activity?.let {
            mainViewModel = ViewModelProviders.of(it).get(MainActivityViewModel::class.java)
            mainViewModel.competitionSelected.observe(it, Observer { competition ->
                viewModel.filterByCompetition(competition)

            })
        }
    }
}