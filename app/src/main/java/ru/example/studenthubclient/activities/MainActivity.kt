package ru.example.studenthubclient.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import ru.example.studenthubclient.R
import ru.example.studenthubclient.adapters.ViewPagerAdapter
import ru.example.studenthubclient.fragments.LoginFragment
import ru.example.studenthubclient.fragments.RegisterFragment

class MainActivity : AppCompatActivity() {
    private val fragmentList = listOf(RegisterFragment(), LoginFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager2)
        viewPager2.adapter = ViewPagerAdapter(this)
    }
}