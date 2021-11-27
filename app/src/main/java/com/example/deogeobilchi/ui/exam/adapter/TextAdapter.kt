package com.example.deogeobilchi.ui.exam.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.deogeobilchi.R
import com.example.deogeobilchi.databinding.ItemTextExamBinding

class TextAdapter : RecyclerView.Adapter<TextAdapter.ViewHolder>() {
    var list = mutableListOf<String>()

    inner class ViewHolder(private val binding: ItemTextExamBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextAdapter.ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_text_exam, parent, false))
    }

    override fun onBindViewHolder(holder: TextAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}