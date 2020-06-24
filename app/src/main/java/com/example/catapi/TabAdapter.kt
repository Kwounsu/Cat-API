package com.example.catapi

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class TabAdapter(private val context: Context, fm: FragmentManager, internal var totalTabs: Int):
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BreedsFragment()
            else -> ImagesFragment()
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}