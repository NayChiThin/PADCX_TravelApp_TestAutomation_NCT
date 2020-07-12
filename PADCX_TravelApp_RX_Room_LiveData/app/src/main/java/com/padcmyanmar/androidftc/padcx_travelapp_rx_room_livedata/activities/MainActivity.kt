package com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.activities

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.R
import com.padcmyanmar.androidftc.padcx_travelapp_rx_room_livedata.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener(object :BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId) {
                    R.id.action_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.flBottomNavigationContainer, HomeFragment())
                            .commit()
                        return true
                    }
                }
                return false
            }

        })
        if(savedInstanceState == null) {

            bottomNavigation.selectedItemId =
                R.id.action_home
        }
    }
}
