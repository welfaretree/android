package com.stac.welfaretree.utils

object Constants {
    const val TAG:String = "로"
}

enum class SEARCH_TYPE{
    USER
}

enum class RESPONSE_STATE{
    OKAY,
    FAIL
}
object API {
    const val BASE_URL : String = "https://api.welfaretree.net/"
    const val SEARCH_WELFARE : String = "search/"
}