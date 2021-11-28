package com.example.deogeobilchi.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.deogeobilchi.R
import com.example.deogeobilchi.databinding.ItemSearchBinding
import com.example.deogeobilchi.model.WorkModel

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    var list = mutableListOf<WorkModel>()

    inner class ViewHolder(private val binding: ItemSearchBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WorkModel) {
            binding.apply {
                company = item.company
                work = item.work
                type = item.type.type
                ivCompany.setImageResource(item.image)
                star = item.star
                ivHeart.isSelected = item.isLike
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_search, parent, false))
    }

    override fun onBindViewHolder(holder: SearchAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}