package com.stac.welfaretree.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.welfaretree.databinding.ActivitySearchWelfareBinding

class SearchWelfareActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySearchWelfareBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        goBack()

    }

    private fun goBack(){
        binding.notificationGoBack.setOnClickListener{
            val intent= Intent(this@SearchWelfareActivity,MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent)
        }
    }
}