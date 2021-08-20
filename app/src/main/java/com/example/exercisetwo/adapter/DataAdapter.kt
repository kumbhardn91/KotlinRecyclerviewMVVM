package com.example.exercisetwo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exercisetwo.R
import com.example.exercisetwo.databinding.RowItemBinding
import com.example.exercisetwo.model.Row
import kotlinx.android.synthetic.main.row_item.view.*


class DataAdapter(private val dataList: List<Row>, val context: Context) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val listItemBinding = RowItemBinding.inflate(inflater,parent,false)
        return DataViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount()=dataList.size

    class DataViewHolder(val itemBinding : RowItemBinding) : RecyclerView.ViewHolder(itemBinding.root)
    {
        fun bind(item: Row){
            itemBinding.listDataItem = item
        }
    }

}