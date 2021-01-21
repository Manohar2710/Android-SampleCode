package com.example.retrofit_example.network

import android.util.Log
import com.example.retrofit_example.model.ResponceData
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkReqApiClient {
    var retrofit:Retrofit? = null
    var okHttpClint:OkHttpClient? = null
    val requestTimeOut = 30
    var key :String = ""

    fun getClient(key:String){
        getClient()
    }

    private fun getClient():Retrofit {
        if(okHttpClint == null){
            initOkHttp()
        }
        retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.google.com")
            .client(okHttpClint)
            .build()
        return retrofit!!
    }

    private fun initOkHttp() {
        var httpClient = OkHttpClient().newBuilder()
            .connectTimeout(requestTimeOut.toLong(),TimeUnit.SECONDS)
            .writeTimeout(requestTimeOut.toLong(),TimeUnit.SECONDS)
            .readTimeout(requestTimeOut.toLong(),TimeUnit.SECONDS)

        val networkLayerLogger = HttpLoggingInterceptor.Logger { message -> Log.i("NetworLayer",message) }
        val appLayerLogger = HttpLoggingInterceptor.Logger { message -> Log.i("App Layer",message) }

        val interceptor = HttpLoggingInterceptor()
        interceptor.level =HttpLoggingInterceptor.Level.BODY
        val networkLogging  = HttpLoggingInterceptor(networkLayerLogger)
        val appLogging = HttpLoggingInterceptor(appLayerLogger)
        networkLogging.level =HttpLoggingInterceptor.Level.HEADERS
        appLogging.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addNetworkInterceptor(networkLogging)
        httpClient.addInterceptor(appLogging)

        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder =original.newBuilder()
                .addHeader("Accept","application/json")
                .addHeader("Request-type","Android")
                .addHeader("Content-type","application/json")

            requestBuilder.addHeader("Authorization","Token $key")
            val request = requestBuilder.build()
            chain.proceed(request)

        }

        okHttpClint = httpClient.build()

    }

    fun requestExampleCall(key: String): Single<ResponceData> {
        return getClient().create(NetworkApiInterface::class.java).requestExampleCall()

    }
}