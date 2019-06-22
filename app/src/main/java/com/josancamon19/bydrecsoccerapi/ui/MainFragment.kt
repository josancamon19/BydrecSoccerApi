package com.josancamon19.bydrecsoccerapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.josancamon19.bydrecsoccerapi.adapters.MatchesPagerAdapter
import com.josancamon19.bydrecsoccerapi.databinding.FragmentMainBinding
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.josancamon19.bydrecsoccerapi.R


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        setupViewPager()
        return binding.root
    }

    private fun setupViewPager() {
        val pagerAdapter = MatchesPagerAdapter(fragmentManager!!)
        binding.viewPager.adapter = pagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

}