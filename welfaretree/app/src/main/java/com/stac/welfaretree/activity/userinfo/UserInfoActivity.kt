package com.stac.welfaretree.activity.userinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.welfaretree.R
import com.example.welfaretree.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_info)

        binding.cbHasJob.setOnCheckedChangeListener { _, isChecked ->
            binding.etJob.isEnabled = !isChecked
            binding.etJob.text.clear()
        }

        binding.btnSubmit.setOnClickListener {
            finish()
        }
    }
}