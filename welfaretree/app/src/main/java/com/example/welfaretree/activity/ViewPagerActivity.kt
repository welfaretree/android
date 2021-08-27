package com.example.welfaretree.activity

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.welfaretree.MyIntroPagerRecyclerAdapter
import com.example.welfaretree.PageItem
import com.example.welfaretree.R
import com.example.welfaretree.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {

    private val binding by lazy { ActivityViewPagerBinding.inflate(layoutInflater) }
    companion object{
        private const val TAG = "ViewPagerActivity"
    }

    private var pageItemList = ArrayList<PageItem>()
    private lateinit var myIntroPagerRecyclerAdapter:MyIntroPagerRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        Log.d(TAG,"ViewPagerActivity - onCreate() called")

        // 데이터 배열 준비
        pageItemList.add(PageItem(R.drawable.pager1,R.string.view_pager_first_title.toString(),R.string.view_pager_first_explain.toString()))
        pageItemList.add(PageItem(R.drawable.pager2,R.string.view_pager_second_title.toString(),R.string.view_pager_second_explain.toString()))
        pageItemList.add(PageItem(R.drawable.pager3,R.string.view_pager_third_title.toString(),R.string.view_pager_third_explain.toString()))

        // no action bar
        if (Build.VERSION.SDK_INT < 16) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        // 어댑터 인스턴스 생성
        myIntroPagerRecyclerAdapter = MyIntroPagerRecyclerAdapter(pageItemList)

        binding.viewPager.adapter = myIntroPagerRecyclerAdapter
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.dotsIndicator.setViewPager2(binding.viewPager)
    }
}