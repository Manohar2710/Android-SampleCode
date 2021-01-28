package com.appscrip.livedatacoroutines.base

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appscrip.livedatacoroutines.R

class UseCaseActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_use_case)
	}

	companion object{
		private const val USE_CASE_EXTRA = "EXTRA_USE_CASE"
		fun newIntent(context: Context,useCaseCategory: UseCaseCategory) =
			Intent(context,UseCaseActivity::class.java).apply {
				putExtra(USE_CASE_EXTRA,useCaseCategory)
			}
		}
}

