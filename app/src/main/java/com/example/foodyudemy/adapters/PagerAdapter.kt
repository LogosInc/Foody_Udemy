package com.example.foodyudemy.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(
    private val resultBundle: Bundle,
    private val fragment: ArrayList<Fragment>,
    fragmentActivity: FragmentActivity
//    private val title: ArrayList<String>,
//    fm: FragmentManager
): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return fragment.size
    }

    override fun createFragment(position: Int): Fragment {
        fragment[position].arguments = resultBundle
        return fragment[position]
    }
}