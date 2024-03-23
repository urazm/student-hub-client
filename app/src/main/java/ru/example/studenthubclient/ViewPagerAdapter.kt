package ru.example.studenthubclient

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private val fragments = listOf(RegisterFragment(), LoginFragment())
    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int) : Fragment = fragments[position]
}

