package com.stac.welfaretree.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.welfaretree.R
import com.example.welfaretree.databinding.ActivityMainBinding
import com.stac.welfaretree.fragment.*
import com.stac.welfaretree.fragment.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val fragmentManager = supportFragmentManager

    private val homeFragment = HomeFragment()
    private val calendarFragment = CalendarFragment()
    private val profileFragment = ProfileFragment()
    private val notificationFragment = NotificationFragment()
    private val settingFragment = SettingFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bottomNavigation()

    }

    private fun bottomNavigation() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.bottomNavigationView.setOnItemSelectedListener {
            val fragmentTransaction = fragmentManager.beginTransaction()
            when (it.itemId) {
                R.id.menu_home -> {
                    fragmentTransaction.replace(R.id.pager, homeFragment).commitAllowingStateLoss()
                    fragmentTransaction.addToBackStack(null)
                }
                R.id.menu_calendar -> {
                    fragmentTransaction.replace(R.id.pager, calendarFragment)
                        .commitAllowingStateLoss()
                    fragmentTransaction.addToBackStack(null)
                }
                R.id.menu_profile -> {
                    fragmentTransaction.replace(R.id.pager, profileFragment)
                        .commitAllowingStateLoss()
                    fragmentTransaction.addToBackStack(null)
                }
                R.id.menu_notification -> {
                    fragmentTransaction.replace(R.id.pager, notificationFragment)
                        .commitAllowingStateLoss()
                    fragmentTransaction.addToBackStack(null)
                }
                R.id.menu_setting -> {
                    fragmentTransaction.replace(R.id.pager, settingFragment)
                        .commitAllowingStateLoss()
                    fragmentTransaction.addToBackStack(null)
                }
            }
            true
        }

        fragmentManager.beginTransaction().add(R.id.pager, HomeFragment()).commitAllowingStateLoss()
    }


}
