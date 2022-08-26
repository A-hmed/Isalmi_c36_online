package com.route.isalmi_c36_online.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.route.isalmi_c36_online.R
import com.route.isalmi_c36_online.home.ahadeth.AhadethFragment
import com.route.isalmi_c36_online.home.quran.QuranFragment
import com.route.isalmi_c36_online.home.radio.RadioFragment
import com.route.isalmi_c36_online.home.sebha.SebhaFragment

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigationView = findViewById(R.id.home_bottom_navigation_view)
        showFragment(QuranFragment())
        bottomNavigationView.setOnItemSelectedListener {item->
            if(item.itemId == R.id.ic_quran){
                showFragment(QuranFragment())
            }else if(item.itemId == R.id.ic_ahadeth){
                showFragment(AhadethFragment())
            }else if(item.itemId == R.id.ic_sebha){
             showFragment(SebhaFragment())
            }else if(item.itemId == R.id.ic_radio){
             showFragment(RadioFragment())
            }
            return@setOnItemSelectedListener true
        }
    }
    fun showFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment).commit()
    }
}