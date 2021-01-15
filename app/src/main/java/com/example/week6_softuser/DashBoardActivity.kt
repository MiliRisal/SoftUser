package com.example.week6_softuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.week6_softuser.Fragment.AboutusFragment
import com.example.week6_softuser.Fragment.AddStudentFragment
import com.example.week6_softuser.Fragment.HomeFragment
import com.example.week6_softuser.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DashBoardActivity : AppCompatActivity() {
    private lateinit var lstTitle : ArrayList<String>
    private lateinit var lstFragments : ArrayList<Fragment>
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        populateList()
        val adapter = ViewPagerAdapter(lstFragments,supportFragmentManager,lifecycle)
        viewPager.adapter =adapter

        TabLayoutMediator(tabLayout,viewPager){ tab, position ->
            tab.text = lstTitle[position]
        }.attach()
    }

    private fun populateList() {
        lstTitle = ArrayList<String>()
        lstTitle.add("Home")
        lstTitle.add("Add Student")
        lstTitle.add("About Us")
        lstFragments = ArrayList<Fragment>()
        lstFragments.add(HomeFragment())
        lstFragments.add(AddStudentFragment())
        lstFragments.add(AboutusFragment())

    }

    override fun getSupportFragmentManager(): FragmentManager {
        return super.getSupportFragmentManager()
    }

}