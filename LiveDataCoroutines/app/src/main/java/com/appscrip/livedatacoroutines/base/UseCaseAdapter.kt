package com.appscrip.livedatacoroutines.base

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appscrip.livedatacoroutines.R
import java.util.zip.Inflater

class UseCaseAdapter(
	private val useCaseCategory: UseCaseCategory,
	private val onUseCaseCategoryClickListener: (UseCase) -> Unit
) : RecyclerView.Adapter<UseCaseAdapter.ViewHolder>() {
	class ViewHolder (val textView:TextView): RecyclerView.ViewHolder(textView)

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val layout = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item,parent,false) as TextView
		return  ViewHolder(layout)
	}


	override fun getItemCount()= useCaseCategory.useCases.size

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.textView.text = useCaseCategory.useCases[position].description
		holder.textView.setOnClickListener {
			onUseCaseCategoryClickListener(useCaseCategory.useCases[position])
		}
	}
}
