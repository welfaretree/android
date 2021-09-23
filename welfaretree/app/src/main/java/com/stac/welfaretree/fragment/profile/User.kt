package com.stac.welfaretree.fragment.profile

data class User (
    val name: String,
    val age: Int,
    val isMale: Boolean,
    val job: String,
    val welfareReceiving: Int,
    val welfareReceived: Int,
    val etcList: List<String>,
    val reviewedWelfareList: List<ProfileReviewedItem>
)