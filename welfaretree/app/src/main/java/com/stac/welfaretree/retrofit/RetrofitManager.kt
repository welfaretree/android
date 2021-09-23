package com.stac.welfaretree.retrofit

import android.util.Log
import com.google.gson.JsonElement
import com.stac.welfaretree.utils.API
import com.stac.welfaretree.utils.Constants.TAG
import com.stac.welfaretree.utils.RESPONSE_STATE
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {

    companion object{
        val instance = RetrofitManager()
    }

    // http call
    // called retrofit interface
    private val welfareInterface : WelfareInterface? = RetrofitClient.getClient(API.BASE_URL)?.create(WelfareInterface::class.java)

    // api call
    fun searchWelfare(dgstName: String?, completion: (RESPONSE_STATE, String) -> Unit){

        val term = dgstName ?: ""
        val call = welfareInterface?.searchWelfare(dgstName = term).let {
            it
        }?:return

        call.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                // response success
                Log.d(TAG,"RetrofitManager - onResponse called / response: ${response.body()}")

                completion(RESPONSE_STATE.OKAY,response.raw().toString())
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                // response failed
                Log.d(TAG,"RetrofitManager - onFailed called / t: $t")
                completion(RESPONSE_STATE.FAIL,t.toString())
            }

        })
    }
}