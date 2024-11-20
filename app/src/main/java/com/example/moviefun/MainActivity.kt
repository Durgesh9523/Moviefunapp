package com.example.moviefun

import MovieParser
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(){
    lateinit var bottomNavigationView:BottomNavigationView
    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.viewPager)
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        // Set up ViewPager adapter
        val adapter = ViewPageAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        // Set up bottom navigation
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_home -> {
                    viewPager.currentItem = 0
                    true
                }
                R.id.action_search -> {
                    viewPager.currentItem = 1
                    true
                }
                R.id.action_fav -> {
                    viewPager.currentItem = 2
                    true
                }
                else -> false
            }
        }

        // Listen to ViewPager changes and sync with bottom navigation
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                bottomNavigationView.menu.getItem(position).isChecked = true
            }
        })
    }

}
