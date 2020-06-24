package com.example.catapi.viewmodel

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.example.catapi.TabAdapter
import com.google.android.material.tabs.TabLayout

class CatViewModel: ViewModel() {
    fun tabLayout(tabLayout:TabLayout, tabs: ArrayList<String>, context: Context, supportFragmentManager: FragmentManager, viewPager:ViewPager) {
        for (i in tabs) {
            tabLayout.addTab(tabLayout.newTab().setText(i))
        }
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = TabAdapter(context, supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {
            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }
}