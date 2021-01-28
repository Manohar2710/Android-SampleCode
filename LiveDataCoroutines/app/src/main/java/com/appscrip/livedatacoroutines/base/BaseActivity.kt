package com.appscrip.livedatacoroutines.base

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.appscrip.livedatacoroutines.R
import com.appscrip.livedatacoroutines.utils.setGone
import com.appscrip.livedatacoroutines.utils.setVisible

abstract class BaseActivity: AppCompatActivity() {

	abstract fun getToolBarTitle():String

	override fun onStart() {
		super.onStart()
		setToolBarTitle(getToolBarTitle())
		getUpButton().setOnClickListener {
			finish()
		}
	}

	private fun getUpButton() : ImageView = findViewById(R.id.btnToolbarBack)

	private fun getToolbar() :TextView = findViewById(R.id.toolbarTitle)

	fun hideUpButton(){
		getUpButton().setGone()
	}
	fun showUpButton(){
		getUpButton().setVisible()
	}
	private fun setToolBarTitle(toolBarTitle:String){
		getToolbar().text = toolBarTitle
	}
}
