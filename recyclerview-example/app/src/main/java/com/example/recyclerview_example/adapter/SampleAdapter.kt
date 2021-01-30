package com.example.recyclerview_example.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_example.R
import com.example.recyclerview_example.model.SampleData

class SampleAdapter(var sampleData:ArrayList<SampleData>) :RecyclerView.Adapter<SampleAdapter.ViewHolder>(){
    init {
        Log.i("SampleAdapter",sampleData.toString())
    }
    lateinit var context:Context
    class ViewHolder( view:View) : RecyclerView.ViewHolder(view) {
        var llRect: LinearLayout = view.findViewById(R.id.llcardViewRect)
        var cardViewSquare: CardView = view.findViewById(R.id.cardViewSquare)
        private var tvNameSquareField: TextView = view.findViewById(R.id.tvNameSquare)
        private var tvNameRectField1: TextView = view.findViewById(R.id.tvNameRect1)
        private var tvNameRectField2: TextView = view.findViewById(R.id.tvNameRect2)

        fun bindView(singleSampleData: SampleData) {
            if(singleSampleData.shape == "square"){
                tvNameSquareField.text = singleSampleData.name
                cardViewSquare.visibility = View.VISIBLE
            }else{
                tvNameRectField1.text = singleSampleData.name
                tvNameRectField1.text = singleSampleData.name
                llRect.visibility = View.VISIBLE

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sample_square_card_view,parent,false)
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