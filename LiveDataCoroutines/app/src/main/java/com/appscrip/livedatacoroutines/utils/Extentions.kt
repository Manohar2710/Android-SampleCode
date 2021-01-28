package com.appscrip.livedatacoroutines.utils

import android.view.View


/***
Extention function to hide and show any view
* */
fun View.setGone(){
	this.visibility = View.GONE
}
fun View.setVisible(){
	this.visibility  = View.VISIBLE
}
