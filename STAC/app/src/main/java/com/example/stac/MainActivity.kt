package com.example.stac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.stac.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding // extension 중지로 인해 binding 사용

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()    // 호출
        initNavigation() // 호출



    }
        // navigation ui를 바인딩으로 찾아주고 id가 navi_host인 프라그먼트를 화면에 띄워준다.
    private fun initNavigation() {
        NavigationUI.setupWithNavController(binding.barName,findNavController(R.id.navi_host))
    }

    private fun initBinding() {
        // 데이터 바인딩
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner = this
    }
}