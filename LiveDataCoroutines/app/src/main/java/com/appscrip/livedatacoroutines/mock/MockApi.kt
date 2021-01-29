package com.appscrip.livedatacoroutines.mock

import android.util.Log
import com.appscrip.livedatacoroutines.usecases.coroutines.usecase1.AndroidVersion
import com.appscrip.livedatacoroutines.utils.MockNetworkInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface MockApi {
	@GET("users")
	suspend fun getRecentAndroidVersions(): List<AndroidVersion>

}
class NetworkReqApiClient {
	var retrofit:Retrofit? = null
	val requestTimeOut = 30
	var key :String = ""
	var okHttpClient:OkHttpClient? = null
	private val BASE_URL = "https://5e510330f2c0d300147c034c.mockapi.io/"

	fun createMockApi(interceptor: MockNetworkInterceptor): MockApi {

		if(okHttpClient == null){
			initOkHttp(interceptor)
		}

		val retrofit = Retrofit.Builder()
			.baseUrl(BASE_URL)
			.client(okHttpClient)
			.addConverterFactory(GsonConverterFactory.create())
			.build()

		return retrofit.create(MockApi::class.java)
	}
	private fun initOkHttp(interceptor: MockNetworkInterceptor) {

		var httpClient = OkHttpClient().newBuilder()
			.connectTimeout(requestTimeOut.toLong(), TimeUnit.SECONDS)
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
		httpClient.addInterceptor(interceptor)

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

		okHttpClient = httpClient.build()

	}

}
