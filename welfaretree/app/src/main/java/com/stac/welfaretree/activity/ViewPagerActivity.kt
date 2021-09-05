package com.stac.welfaretree.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.stac.welfaretree.MyIntroPagerRecyclerAdapter
import com.stac.welfaretree.PageItem
import com.example.welfaretree.R
import com.example.welfaretree.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {

    private val binding by lazy { ActivityViewPagerBinding.inflate(layoutInflater) }

    companion object {
        private const val TAG = "ViewPagerActivity"
    }

    private var pageItemList = ArrayList<PageItem>()
    private lateinit var myIntroPagerRecyclerAdapter: MyIntroPagerRecyclerAdapter

    private val btn by lazy { findViewById<Button>(R.id.keep_go_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        Log.d(TAG, "ViewPagerActivity - onCreate() called")

        setIntroPagerItem()
        createInstance()
        noActionBar()
    }

    private fun setIntroPagerItem() {
        myIntroPagerRecyclerAdapter = MyIntroPagerRecyclerAdapter(
            arrayListOf(
                PageItem(
                    imageSrc = R.drawable.pager1,
                    title = "이 앱은 당신의 복지를 찾아줍니다",
                    explain = "본 앱은 당신의 인적사항을 토대로 받을 수 있는 복지를 보여줍니다."
                ),
                PageItem(
                    imageSrc = R.drawable.pager2,
                    title = "알람을 통해서 복지기간을 알려줍니다",
                    explain = "본 앱은 당신의 복지 기간을 알려줍니다."
                ),
                PageItem(
                    imageSrc = R.drawable.pager3,
                    title = "이제 직접 사용해봅시다 !",
                    explain = ""
                )
            )
        )
        val wfViewPager = findViewById<ViewPager2>(R.id.view_pager)
        wfViewPager.adapter = myIntroPagerRecyclerAdapter
    }

    private fun createInstance() {
        // 어댑터 인스턴스 생성
        myIntroPagerRecyclerAdapter = MyIntroPagerRecyclerAdapter(pageItemList)

        binding.viewPager.adapter = myIntroPagerRecyclerAdapter
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.dotsIndicator.setViewPager2(binding.viewPager)
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