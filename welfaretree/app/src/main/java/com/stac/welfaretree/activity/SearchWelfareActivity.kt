package com.stac.welfaretree.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.Toast
import com.example.welfaretree.databinding.ActivitySearchWelfareBinding
import com.stac.welfaretree.retrofit.RetrofitManager
import com.stac.welfaretree.utils.RESPONSE_STATE


class SearchWelfareActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySearchWelfareBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        goBack()

        binding.notificationSearch.setOnKeyListener{v,keyCode,event->
            if(keyCode == KeyEvent.KEYCODE_ENTER && event.action == MotionEvent.ACTION_DOWN){
                RetrofitManager.instance.searchWelfare(dgstName = binding.notificationSearch.text.toString(), completion = {
                        responseState, responseBody ->

                    when(responseState){
                        RESPONSE_STATE.OKAY->{
                            Log.d(TAG,"api 호출 성공 : $responseBody")
                        }
                        RESPONSE_STATE.FAIL->{
                            Toast.makeText(this,"api 호출 에러입니다.",Toast.LENGTH_SHORT).show()
                            Log.d(TAG,"api 호출 실패 : $responseBody")
                        }
                    }
                })
                return@setOnKeyListener true
            }
                return@setOnKeyListener false
        }
    }


    private fun goBack(){
        binding.notificationGoBack.setOnClickListener{
            val intent= Intent(this@SearchWelfareActivity,MainActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent)
        }
    }
    companion object{
        private const val TAG = "MainActivity"
    }
}