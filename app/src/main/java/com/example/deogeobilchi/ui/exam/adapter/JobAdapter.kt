package com.example.deogeobilchi.ui.exam.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.deogeobilchi.R
import com.example.deogeobilchi.databinding.ItemJobExamBinding
import com.example.deogeobilchi.model.EnumExamType
import com.example.deogeobilchi.model.ExamType
import com.example.deogeobilchi.model.ExamTypeDetail

class JobAdapter : RecyclerView.Adapter<JobAdapter.ViewHolder>() {
    private val TAG = "TAGexam"
    var list = mutableListOf<EnumExamType>()

    inner class ViewHolder(private val binding: ItemJobExamBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: EnumExamType) {
            val mType: ExamTypeDetail = ExamType().getTypeDetail(item)
            var mJobs = ""
            binding.apply {
                type = item.type
                mType.job.forEach {
                    mJobs += "$it, "
                }
                jobs = mJobs + "등"

                // Log.d(TAG, "bind: type = $type, jobs = $mJobs")
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobAdapter.ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_job_exam, parent, false))
    }

    override fun onBindViewHolder(holder: JobAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}