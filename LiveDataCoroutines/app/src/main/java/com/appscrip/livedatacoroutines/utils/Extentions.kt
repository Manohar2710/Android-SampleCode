package com.appscrip.livedatacoroutines.utils

import android.content.Context
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.view.View
import android.widget.Toast


/***
Extention function to hide and show any view
* */
fun View.setGone(){
	this.visibility = View.GONE
}
fun View.setVisible(){
	this.visibility  = View.VISIBLE
}
fun fromHtml(source: String): Spanned {
	return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
		Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY)
	} else {
		@Suppress("DEPRECATION")
		Html.fromHtml(source)
	}
}
fun Context?.toast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) =
	this?.let { Toast.makeText(it, text, duration).show() }
