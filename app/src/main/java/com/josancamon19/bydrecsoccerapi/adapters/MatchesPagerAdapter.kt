package com.josancamon19.bydrecsoccerapi.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.josancamon19.bydrecsoccerapi.ui.FixturesFragment
import com.josancamon19.bydrecsoccerapi.ui.ResultsFragment

class MatchesPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FixturesFragment()
            1 -> ResultsFragment()
            else -> FixturesFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "FIXTURES"
            1 -> "RESULTS"
            else -> super.getPageTitle(position)
        }
    }
}