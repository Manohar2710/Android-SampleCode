package com.appscrip.livedatacoroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay

class DataSourceFile(private val ioDispatcher: CoroutineDispatcher) : DataSource {
	override fun getCurrentTime() : LiveData<Long> =
		liveData{
			while(true){
				emit(System.currentTimeMillis())
				delay(1000)
			}
		}
}
interface DataSource{
	fun getCurrentTime(): LiveData<Long>
}
