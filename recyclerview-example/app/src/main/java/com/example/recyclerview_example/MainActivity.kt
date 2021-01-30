package com.example.recyclerview_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_example.adapter.SampleAdapter
import com.example.recyclerview_example.mock.data.SAMPLE_DUMMY_DATA
import com.example.recyclerview_example.model.SampleData

class MainActivity : AppCompatActivity() {
    lateinit var rvSampleData : RecyclerView
    lateinit var sampleDataAdapter : SampleAdapter
    var sampleDataList : ArrayList<SampleData> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
    }

    private fun initUI() { 
        setContentView(R.layout.activity_main)
        rvSampleData = findViewById(R.id.rv_sample_data)
        sampleDataAdapter = SampleAdapter(sampleDataList)
        rvSampleData.adapter = sampleDataAdapter
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvSampleData.layoutManager = linearLayoutManager
        rvSampleData.hasFixedSize()
        sampleDataList.addAll( SAMPLE_DUMMY_DATA)
        Log.i("sampleDataList",sampleDataList.toString())
        sampleDataAdapter.notifyDataSetChanged()
    }
}