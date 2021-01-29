package com.appscrip.livedatacoroutines.usecases.coroutines.usecase1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.appscrip.livedatacoroutines.R
import com.appscrip.livedatacoroutines.base.BaseActivity
import com.appscrip.livedatacoroutines.base.useCaseDescription1
import com.appscrip.livedatacoroutines.databinding.ActivitySingleNetworkRequestBinding
import com.appscrip.livedatacoroutines.utils.fromHtml
import com.appscrip.livedatacoroutines.utils.setGone
import com.appscrip.livedatacoroutines.utils.setVisible
import com.appscrip.livedatacoroutines.utils.toast
import kotlinx.android.synthetic.main.activity_single_network_request.*

class SingleNetworkRequestActivity : BaseActivity() {
	private val binding by lazy {ActivitySingleNetworkRequestBinding.inflate(layoutInflater) }
	private val viewModel : SingleNetworkRequestViewModel  by viewModels()
	override fun getToolBarTitle() = useCaseDescription1

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)
		viewModel.uiState().observe(this,{ uiState ->
			if(uiState != null){
				render(uiState)
			}
		})
		binding.btnPerformSingleNetworkRequest.setOnClickListener {
			viewModel.perFormSingleNetworkResquest()
		}
		Log.i("SingleNetworkRequest","onCreate")

	}

	private fun render(uiState: UiState) {
		when(uiState){
			is UiState.Loading -> {
				onLoad()
			}
			is UiState.Success -> {
				onSuccess(uiState)
			}
			is UiState.Error -> {
				onError(uiState)
			}
		}
	}

	private fun onLoad() = with(binding){
		progressBar.setVisible()
		textViewResult.text = ""
		btnPerformSingleNetworkRequest.isEnabled = false
	}

	private fun onSuccess(uiState: UiState.Success) = with(binding){
		progressBar.setGone()
		btnPerformSingleNetworkRequest.isEnabled = true
		val readableVersions = uiState.recentVersion.map { "API ${it.apiLevel}: ${it.name}" }
		textViewResult.text = fromHtml(
			"<b>Recent Android Versions</b><br>${readableVersions.joinToString(separator = "<br>")}"
		)

	}

	private fun onError(uiState: UiState.Error) = with(binding){
		progressBar.setGone()
		btnPerformSingleNetworkRequest.isEnabled = true
		toast(uiState.message)

	}
}
