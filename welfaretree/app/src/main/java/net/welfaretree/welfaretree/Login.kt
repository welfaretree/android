package net.welfaretree.welfaretree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import net.welfaretree.welfaretree.databinding.ActivityLoginBinding


class Login : AppCompatActivity() {

    val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.signupText.setOnClickListener {
            val SignUpText = Intent(this@Login, SignUp::class.java)
            startActivity(SignUpText)
        }

        binding.loginButton.setOnClickListener {
            val loginIntent = Intent(this@Login, MainActivity::class.java)
            startActivity(loginIntent)
            Toast.makeText(this@Login, "로그인 성공!", Toast.LENGTH_SHORT).show()
        }
    }


}