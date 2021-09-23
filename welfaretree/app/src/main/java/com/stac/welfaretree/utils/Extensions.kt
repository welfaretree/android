package com.stac.welfaretree.utils

// 문자열이 json 형태인지
fun String?.isJsonObject():Boolean = this?.startsWith("{") == true && this.endsWith("}")

// 문자열이 json 배열인지
fun String?.isJsonArray():Boolean = this?.startsWith("[") == true && this.endsWith("]")