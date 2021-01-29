package com.appscrip.livedatacoroutines.usecases.coroutines.usecase1

sealed class UiState {
	object Loading :UiState()
	data class Success(val recentVersion:List<AndroidVersion>):UiState()
	data class Error(val message:String):UiState()
}
