package com.stac.welfaretree.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.stac.welfaretree.ViewPagerAdapter
import com.example.welfaretree.R
import me.relex.circleindicator.CircleIndicator3

class ViewPagerActivity : AppCompatActivity() {

    private var titlesList = mutableListOf<String>()
    private var descriptionList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()

    companion object {
        private const val TAG = "ViewPagerActivity"
    }

    private val keepGoBtn by lazy { findViewById<Button>(R.id.keep_go_button) }
    private val viewPager by lazy { findViewById<ViewPager2>(R.id.view_pager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        postToList()
        btnEvent()
        noActionBar()

        viewPager.adapter = ViewPagerAdapter(titlesList, descriptionList, imagesList)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(viewPager)
    }

    private fun addToList(title: String, description: String, image: Int) {
        titlesList.add(title)
        descriptionList.add(description)
        imagesList.add(image)
    }

    private fun postToList() {
        addToList("이 앱은 당신의 복지를 찾아줍니다", "본 앱은 당신의 인적사항을 토대로 받을 수 있는 복지를 보여줍니다.", R.drawable.pager1)
        addToList("알람을 통해서 복지기간을 알려줍니다", "본 앱은 당신의 복지 기간을 알려줍니다.", R.drawable.pager2)
        addToList("이제 직접 사용해봅시다 !", "", R.drawable.pager3)
    }

    private fun btnEvent() {
        keepGoBtn.setOnClickListener {

            if (viewPager.currentItem +2 == ViewPagerAdapter(
                    titlesList,
                    descriptionList,
                    imagesList
                ).itemCount
            ) {
                keepGoBtn.text = "시작하기"
                keepGoBtn.setTextColor(resources.getColor(R.color.white))
                keepGoBtn.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.button_radius_last))
            }


            if (viewPager.currentItem + 1 < ViewPagerAdapter(
                    titlesList,
                    descriptionList,
                    imagesList
                ).itemCount
            ) {
                viewPager.currentItem += 1
                Log.d(TAG, "keepgobtn")
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }


    private fun noActionBar() {
        // no action bar
        if (Build.VERSION.SDK_INT < 16) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
    }
}