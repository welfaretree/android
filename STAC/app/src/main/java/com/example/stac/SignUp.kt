package com.example.stac

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.stac.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {

    val binding by lazy { ActivitySignUpBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.signUpButton.setOnClickListener{
            val SignUpIntent = Intent(this@SignUp, Login::class.java)
            startActivity(SignUpIntent)
            Toast.makeText(this@SignUp, "회원가입 성공!", Toast.LENGTH_SHORT).show()
        }
    }
}