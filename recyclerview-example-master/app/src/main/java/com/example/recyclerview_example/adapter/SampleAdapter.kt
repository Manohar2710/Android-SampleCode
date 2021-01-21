package com.example.recyclerview_example.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_example.R
import com.example.recyclerview_example.model.SampleData

class SampleAdapter(var sampleData:ArrayList<SampleData>) :RecyclerView.Adapter<SampleAdapter.ViewHolder>(){
    init {
        Log.i("SampleAdapter",sampleData.toString())
    }
    lateinit var context:Context
    class ViewHolder( view:View) : RecyclerView.ViewHolder(view) {
        var tvTestingField: TextView = view.findViewById(R.id.tv_testing_field)
        fun bindView(singleSampleData: SampleData) {
            tvTestingField.text = singleSampleData.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sample_card_view,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val singleSampleData = sampleData[position]
        holder.bindView(singleSampleData)
    }

    override fun getItemCount(): Int {
       return sampleData.size
    }
}