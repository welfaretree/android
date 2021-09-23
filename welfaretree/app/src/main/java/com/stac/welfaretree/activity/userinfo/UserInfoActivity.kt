package com.stac.welfaretree.activity.userinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.welfaretree.R
import com.example.welfaretree.databinding.ActivityUserInfoBinding
import com.stac.welfaretree.fragment.profile.User
import com.stac.welfaretree.fragment.profile.UserManager
import kotlinx.coroutines.*

class UserInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserInfoBinding
    val TAG = "UserManager"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_info)

        binding.cbHasJob.setOnCheckedChangeListener { _, isChecked ->
            binding.etJob.isEnabled = !isChecked
            binding.etJob.text.clear()
        }

        binding.btnSubmit.setOnClickListener {
            saveUserInfo()
        }

        loadUserInfo()
    }

    private fun saveUserInfo() {
        if (binding.etName.text.isEmpty() || binding.etAge.text.isEmpty()) {
            Toast.makeText(this, "정보를 입력해주세요", Toast.LENGTH_SHORT).show()

            return
        }


        var user = User(
            null,
            binding.etName.text.toString(),
            Integer.parseInt(binding.etAge.text.toString()),
            if(binding.rbMale.isChecked) "남자" else "여자",
            if(binding.etJob.text.toString().isEmpty()) "없음" else binding.etJob.text.toString(),
            0,
            0,
            null,
            null
        )

        Log.d(TAG, "saveUserInfo: $user")

        CoroutineScope(Dispatchers.IO).launch {
            UserManager(applicationContext).saveUser(user)
        }
        finish()
    }

    private fun loadUserInfo() {
        CoroutineScope(Dispatchers.IO).launch {
            val user = UserManager(applicationContext).getUser()

            withContext(Dispatchers.Main) {
                binding.etName.setText(user.name)
                binding.etAge.setText(user.age.toString())
                if (user.gender == "남자") {
                    binding.rbMale.isChecked = true
                    binding.rbFemale.isChecked= false
                } else {
                    binding.rbMale.isChecked = false
                    binding.rbFemale.isChecked = true
                }
                binding.etJob.setText(user.job)
            }
        }
    }
}