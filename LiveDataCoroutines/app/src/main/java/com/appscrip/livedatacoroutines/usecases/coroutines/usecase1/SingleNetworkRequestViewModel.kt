package com.appscrip.livedatacoroutines.usecases.coroutines.usecase1

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.appscrip.livedatacoroutines.base.BaseViewModel
import com.appscrip.livedatacoroutines.mock.MockApi
import kotlinx.coroutines.launch

class SingleNetworkRequestViewModel(
	private val mockApi : MockApi = mockApi()
) : BaseViewModel<UiState>() {
	fun perFormSingleNetworkResquest(){
		uiState.value = UiState.Loading
		viewModelScope.launch {
			try{
				val recentAndroidVersion = mockApi.getRecentAndroidVersions()
				uiState.value = UiState.Success(recentAndroidVersion)
			}catch (err:Exception){
				Log.e("err","$err")
				uiState.value = UiState.Error("Network Request failed!")
			}
		}

	}
}
