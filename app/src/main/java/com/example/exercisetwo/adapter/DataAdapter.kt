package com.example.exercisetwo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercisetwo.databinding.RowItemBinding
import com.example.exercisetwo.model.Row


class DataAdapter(private val dataList: List<Row>) :
    RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val listItemBinding = RowItemBinding.inflate(inflater, parent, false)
        return DataViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    class DataViewHolder(private val itemBinding: RowItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Row) {
            itemBinding.listDataItem = item
        }
    }

}