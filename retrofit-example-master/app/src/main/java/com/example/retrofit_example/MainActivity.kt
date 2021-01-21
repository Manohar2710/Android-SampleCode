package com.example.retrofit_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.retrofit_example.network.NetworkReqApiClient
import com.example.retrofit_example.viewmodel.MainActivityViewModel
import io.reactivex.disposables.CompositeDisposable

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityViewModel : MainActivityViewModel
    private val compositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        listenToObservabels()
        callExampleData()

    }

    private fun listenToObservabels() {
        val disposable1 = mainActivityViewModel.resultResponse.subscribe{
                Log.i("resultResponse",it.data)
        }
        val disposable2 = mainActivityViewModel.resultResponseError.subscribe{
            Log.i("resultResponseError",it)
        }
        compositeDisposable.addAll(disposable1,disposable2)
    }

    private fun initViewModel() {
        mainActivityViewModel = ViewModelProviders
            .of(this)[MainActivityViewModel::class.java]
        mainActivityViewModel.networkReqApiClient = NetworkReqApiClient()
    }
    private fun callExampleData() {
        mainActivityViewModel.requestExampleCall("")
    }
}