package com.appscrip.livedatacoroutines.usecases.coroutines.usecase1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.appscrip.livedatacoroutines.R
import com.appscrip.livedatacoroutines.base.BaseActivity
import com.appscrip.livedatacoroutines.base.useCaseDescription1
import com.appscrip.livedatacoroutines.databinding.ActivitySingleNetworkRequestBinding

class SingleNetworkRequestActivity : BaseActivity() {
	private val binding by lazy {ActivitySingleNetworkRequestBinding.inflate(layoutInflater) }
	override fun getToolBarTitle() = useCaseDescription1

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)
		Log.i("SingleNetworkRequestActivity","onCreate")

	}
}
