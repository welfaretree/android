package com.stac.welfaretree.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.welfaretree.R
import com.example.welfaretree.databinding.ActivityDetailWelfareBinding

class DetailWelfareActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailWelfareBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
    
}