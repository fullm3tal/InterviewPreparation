package com.fullm3tal.interviewpreparation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fullm3tal.interviewpreparation.databinding.ViewListItemBinding

class ListAdapter(val list: List<String>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ViewListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ListViewHolder(val binding: ViewListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {

        }
    }

}