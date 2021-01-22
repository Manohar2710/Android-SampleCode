package com.appscrip.livedatacoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.appscrip.livedatacoroutines.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private val viewModel : LiveDataViewModel by viewModels {DataSourceVMFactory}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
		val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main,)
		binding.lifecycleOwner = this
		binding.liveData = viewModel


    }
}
