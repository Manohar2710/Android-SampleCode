package com.appscrip.livedatacoroutines.base

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appscrip.livedatacoroutines.R

class UseCaseCategoryAdapter(
	private val useCaseCategories: List<UseCaseCategory>,
	private val onUseCaseCategoryClickListener: (UseCaseCategory) -> Unit
) :RecyclerView.Adapter<UseCaseCategoryAdapter.ViewHolder>() {

	class ViewHolder(val textView: TextView) :RecyclerView.ViewHolder(textView)

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): ViewHolder {
		val textView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item,parent,false) as TextView
		return ViewHolder(textView)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.textView.text = useCaseCategories[position].categoryName
		holder.textView.setOnClickListener {
			onUseCaseCategoryClickListener(useCaseCategories[position])
		}
	}

	override fun getItemCount() = useCaseCategories.size
}
