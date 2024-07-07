package com.example.alkyeassignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alkyeassignment.databinding.ItemRvBottomBinding

class BottomAdapter(
    val count: Int = 0
): RecyclerView.Adapter<BottomAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRvBottomBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = count

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    class ViewHolder(private val binding: ItemRvBottomBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(){}
    }
}