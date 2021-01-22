package com.example.retrofit_example.viewmodel

import androidx.lifecycle.ViewModel
import com.example.retrofit_example.model.ResponceData
import com.example.retrofit_example.network.NetworkReqApiClient
import com.example.retrofit_example.utils.SchedulersWrapper
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.subjects.BehaviorSubject

class MainActivityViewModel:ViewModel() {
    val scheduler = SchedulersWrapper()
    var networkReqApiClient = NetworkReqApiClient()
    val resultResponse :BehaviorSubject<ResponceData> = BehaviorSubject.create()
    val resultResponseError :BehaviorSubject<String> = BehaviorSubject.create()

    fun requestExampleCall(key:String){
        val disposable = networkReqApiClient.requestExampleCall(key).observeOn(scheduler.main()).subscribeOn(scheduler.io())
            .subscribeWith(object : DisposableSingleObserver<ResponceData>(){
                override fun onSuccess(t: ResponceData) {
                    resultResponse.onNext(t)
                }

                override fun onError(e: Throwable) {
                    resultResponseError.onNext("Error")
                }

            })
    }
}