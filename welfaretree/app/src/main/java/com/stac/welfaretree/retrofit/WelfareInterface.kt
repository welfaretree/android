package com.stac.welfaretree.retrofit

import com.google.gson.JsonElement
import com.stac.welfaretree.utils.API
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface WelfareInterface {

    //https://api.welfaretree.net/search?name=""
    @GET(API.SEARCH_WELFARE)
    fun searchWelfare(
        @Query("dgst") dgstName: String
    ): Call<JsonElement>
}