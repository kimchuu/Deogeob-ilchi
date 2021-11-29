package com.example.deogeobilchi.ui.main.community

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.deogeobilchi.R
import com.example.deogeobilchi.databinding.ItemCommunityBinding
import com.example.deogeobilchi.model.CommunityModel

class CommunityAdapter : RecyclerView.Adapter<CommunityAdapter.ViewHolder>() {
    var list = mutableListOf<CommunityModel>()

    inner class ViewHolder(private val binding: ItemCommunityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CommunityModel) {
            binding.apply {
                title = item.title
                contents = item.contents
                time = item.time
                writer = item.writer
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityAdapter.ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_community, parent, false))
    }

    override fun onBindViewHolder(holder: CommunityAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}