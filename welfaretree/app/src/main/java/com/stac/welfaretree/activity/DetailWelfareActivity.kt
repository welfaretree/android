package com.stac.welfaretree.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.welfaretree.R
import com.example.welfaretree.databinding.ActivityDetailWelfareBinding

class DetailWelfareActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailWelfareBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.goToBackPage.setOnClickListener{
            val intent = Intent(this,SearchWelfareActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
    }

}