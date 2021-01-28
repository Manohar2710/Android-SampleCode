package com.appscrip.livedatacoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.appscrip.livedatacoroutines.base.*
import com.appscrip.livedatacoroutines.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

//	private val viewModel : LiveDataViewModel by viewModels {DataSourceVMFactory}
	private lateinit var binding : ActivityMainBinding
	override fun getToolBarTitle() = "Coroutine Usecases on Android"

	override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		initRecyclerView()
		hideUpButton()


    }
	private val onUseCaseCategoryClickListener:(UseCaseCategory) -> Unit = {
		val intent = UseCaseActivity.newIntent(applicationContext,it)
		startActivity(intent)
	}
	private fun initRecyclerView() {
		binding.recyclerView.apply {
			adapter = UseCaseCategoryAdapter(
				useCaseCategories,
				onUseCaseCategoryClickListener
			)
			hasFixedSize()
			layoutManager = LinearLayoutManager(this@MainActivity)
		}
	}

}
