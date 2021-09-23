package com.stac.welfaretree.retrofit

import android.content.ContentValues.TAG
import android.util.Log
import com.stac.welfaretree.utils.isJsonArray
import com.stac.welfaretree.utils.isJsonObject
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.security.SecureRandom
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import javax.security.cert.X509Certificate

// single
object RetrofitClient {

    // declare
    private var retrofitClient: Retrofit? = null

    // get client
    fun getClient(baseUrl:String): Retrofit? {
        Log.d(TAG,"RetrofitClient - getClient() called")
        val client = OkHttpClient.Builder()

        // for log, add logging interceptor
        // 로깅 처리, 기본 파라미터 추가 가능
        val loggingInterceptor = HttpLoggingInterceptor(object: HttpLoggingInterceptor.Logger{
            override fun log(message: String) {
                Log.d(TAG,"RetrofitClient - log() called / message : $message")

                when{
                    message.isJsonObject() ->
                        Log.d(TAG,JSONObject(message).toString(4))
                    message.isJsonArray() ->
                        Log.d(TAG,JSONObject(message).toString(4))
                    else ->
                        try {
                            Log.d(TAG,JSONObject(message).toString(4))
                        }catch (e:Exception){
                            Log.d(TAG,message)
                        }
                }
            }

        })

        // 위에서 설정한 loggingInterceptor를 okhttp client에 추가
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        client.addInterceptor(loggingInterceptor)

        // 기본 파라매터 인터셉터 설정
        val baseParameterInterceptor : Interceptor = (Interceptor { chain ->
            Log.d(TAG, "RetrofitClient - intercept() called")
            // 오리지날 리퀘스트
            val originalRequest = chain.request()

            // ?client_id=asdfadsf
            // 쿼리 파라매터 추가하기
            val addedUrl = originalRequest.url.newBuilder().addQueryParameter("from", "2000-01-01").build()

            val finalRequest = originalRequest.newBuilder()
                .url(addedUrl)
                .method(originalRequest.method, originalRequest.body)
                .build()

            chain.proceed(finalRequest)
        })
        // 위에서 설정한 기본파라미터 인터셉터를 okhttp 클라이언트에 추가한다
        client.addInterceptor(baseParameterInterceptor)

        // connection timeout
        client.connectTimeout(10,TimeUnit.SECONDS)
        client.readTimeout(10,TimeUnit.SECONDS)
        client.writeTimeout(10,TimeUnit.SECONDS)
        client.retryOnConnectionFailure(true)


        // create instance
        if(retrofitClient == null){
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getUnsafeOkHttpClient().build())
                .client(client.build())
                .build()
        }

        return retrofitClient
    }

    private fun getUnsafeOkHttpClient(): OkHttpClient.Builder {
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            override fun checkClientTrusted(
                chain: Array<out java.security.cert.X509Certificate>?,
                authType: String?
            ) {

            }

            override fun checkServerTrusted(
                chain: Array<out java.security.cert.X509Certificate>?,
                authType: String?
            ) {

            }

            override fun getAcceptedIssuers(): Array<out java.security.cert.X509Certificate>? {
                return arrayOf()
            }
        })

        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, SecureRandom())

        val sslSocketFactory = sslContext.socketFactory

        val builder = OkHttpClient.Builder()
        builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
        builder.hostnameVerifier { hostname, session -> true }

        return builder
    }
}