package com.example.deogeobilchi.ui.exam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deogeobilchi.R
import com.example.deogeobilchi.databinding.ItemResultExamBinding
import com.example.deogeobilchi.model.EnumExamType
import com.example.deogeobilchi.model.ExamType
import com.example.deogeobilchi.model.ExamTypeDetail

class ResultAdapter : RecyclerView.Adapter<ResultAdapter.ViewHolder>() {
    var list = mutableListOf<EnumExamType>()

    inner class ViewHolder(private val binding: ItemResultExamBinding, context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        val context = context

        fun bind(item: EnumExamType, position: Int) {
            val mType: ExamTypeDetail = ExamType().getTypeDetail(item)
            var mFeatureAdapter = TextAdapter()
            var mPreferAdapter = TextAdapter()
            mFeatureAdapter.list = mType.feature
            mPreferAdapter.list = mType.prefer

            binding.apply {
                type = item.type
                number = position + 1
                featureAdapter = mFeatureAdapter
                rvFeatureList.layoutManager = LinearLayoutManager(context)
                preferAdapter = mPreferAdapter
                rvPreferList.layoutManager = LinearLayoutManager(context)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultAdapter.ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_result_exam, parent, false), parent.context)
    }

    override fun onBindViewHolder(holder: ResultAdapter.ViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}