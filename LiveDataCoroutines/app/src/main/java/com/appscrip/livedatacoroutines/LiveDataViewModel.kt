package com.appscrip.livedatacoroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers

class LiveDataViewModel(private val dataSource: DataSourceFile) : ViewModel() {

	val currentMilliSec = dataSource.getCurrentTime()
	companion object{

	}
}

object DataSourceVMFactory : ViewModelProvider.Factory {
	
	private val dataSource = DataSourceFile(Dispatchers.IO)
	
	@Suppress("UNCHECKED_CAST")
	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		return LiveDataViewModel(dataSource) as T
	}

}
