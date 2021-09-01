package com.example.welfaretree.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.welfaretree.R
import com.example.welfaretree.databinding.ActivityMainBinding
import com.example.welfaretree.fragment.*
import com.google.android.material.snackbar.Snackbar

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
        supportActionBar()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tool_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item!!.itemId) {
            R.id.action_search -> {
                Snackbar.make(findViewById(R.id.toolbar), "search pressed", Snackbar.LENGTH_SHORT)
                    .show()
            }
            R.id.action_share -> {
                Snackbar.make(findViewById(R.id.toolbar),"share pressed",Snackbar.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
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

    private fun supportActionBar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.setDisplayShowTitleEnabled(true) // 타이틀 보이게 설정
    }

}
