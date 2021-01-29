package com.appscrip.livedatacoroutines.base

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.appscrip.livedatacoroutines.databinding.ActivityUseCaseBinding

class UseCaseActivity : BaseActivity() {

	private val useCaseCategory by lazy { intent.getParcelableExtra<UseCaseCategory>(USE_CASE_EXTRA)!! }
	private lateinit var binding : ActivityUseCaseBinding
	override fun getToolBarTitle() = useCaseCategory.categoryName

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityUseCaseBinding.inflate(layoutInflater)
		setContentView(binding.root)
		initRecyclerView()

	}
	private val onUseCaseCategoryClickListener :(UseCase) -> Unit = {
		startActivity(Intent(applicationContext,it.targetActivity))
	}
	private fun initRecyclerView() {
		binding.recyclerView.apply {
			Log.i("UseCaseActivity","useCaseCategory $useCaseCategory")
			adapter = UseCaseAdapter(
				useCaseCategory,
				onUseCaseCategoryClickListener
			)
			hasFixedSize()
			layoutManager = LinearLayoutManager(this@UseCaseActivity)
		}
	}

	companion object{
		private const val USE_CASE_EXTRA = "EXTRA_USE_CASE"
		fun newIntent(context: Context,useCaseCategory: UseCaseCategory) =
			Intent(context,UseCaseActivity::class.java).apply {
				putExtra(USE_CASE_EXTRA,useCaseCategory)
			}
		}
}

