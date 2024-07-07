package com.example.alkyeassignment

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alkyeassignment.adapters.BottomAdapter
import com.example.alkyeassignment.adapters.MiddleAdapter
import com.example.alkyeassignment.adapters.TopAdapter
import com.example.alkyeassignment.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setListenersAdapters()
//        setTabLayout()
    }

    private fun setTabLayout() {

        val tabIcons = listOf(
            R.drawable.ic_book_open,
            R.drawable.ic_bookmark,
            R.drawable.ic_watch,
            R.drawable.ic_notification,
            R.drawable.ic_profile
        )

        for (i in tabIcons.indices) {
            val tab = binding.tabLayout.newTab()
            val customView = layoutInflater.inflate(R.layout.tab_item, null)
            val tabIcon = customView.findViewById<ImageView>(R.id.imgTab)
            tabIcon.setImageResource(tabIcons[i])
            tab.customView = customView
            binding.tabLayout.addTab(tab)
        }
    }

    private fun setListenersAdapters(){
        Toast.makeText(this, "Tap to continue", Toast.LENGTH_SHORT).show()
        binding.landingScreen.setOnClickListener {
            binding.landingScreen.visibility = View.GONE
            binding.mainScreen.visibility = View.VISIBLE
            binding.tabLayout.visibility = View.VISIBLE
        }
        binding.rvTop.adapter = TopAdapter(3)
        binding.rvMiddle.adapter = MiddleAdapter(4)
        binding.rvBottom.adapter = BottomAdapter(4)
    }

}