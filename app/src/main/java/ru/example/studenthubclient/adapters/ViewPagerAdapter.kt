package ru.example.studenthubclient.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.example.studenthubclient.fragments.LoginFragment
import ru.example.studenthubclient.fragments.RegisterFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private val fragments = listOf(RegisterFragment(), LoginFragment())
    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int) : Fragment = fragments[position]
}

