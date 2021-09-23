package com.stac.welfaretree.utils

object Constants {
    const val TAG:String = "로그"
}

enum class SEARCH_TYPE{
    USER
}

enum class RESPONSE_STATE{
    OKAY,
    FAIL
}
object API {
    const val BASE_URL : String = "https://f1sb2lxox0.execute-api.ap-northeast-2.amazonaws.com/"
    const val SEARCH_WELFARE : String = "search"
}