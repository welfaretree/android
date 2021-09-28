package com.stac.welfaretree.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        binding.notificationSeeList.setOnClickListener{
            RetrofitManager.instance.searchWelfare(dgstName = binding.notificationSearch.toString(), completion = {
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