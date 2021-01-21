package com.example.retrofit_example.network

import com.example.retrofit_example.model.ResponceData
import io.reactivex.Single
import retrofit2.http.GET

interface NetworkApiInterface {
    @GET("/get_data")
    fun requestExampleCall(): Single<ResponceData>


}