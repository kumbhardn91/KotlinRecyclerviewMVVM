package com.example.exercisetwo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercisetwo.adapter.DataAdapter
import com.example.exercisetwo.databinding.ActivityMainBinding
import com.example.exercisetwo.model.ModelClass
import com.example.exercisetwo.model.Row
import com.example.exercisetwo.viewmodel.DataViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {

    private val dataViewModel: DataViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var manager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataList: List<Row> = dataViewModel.generateDataList()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manager = LinearLayoutManager(this)
        binding.recyclerView.apply {
            adapter = DataAdapter(dataList,applicationContext)
            layoutManager = manager
        }

    }

}