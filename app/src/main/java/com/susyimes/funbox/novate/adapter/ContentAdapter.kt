package com.susyimes.funbox.novate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.susyimes.funbox.novate.R
import com.susyimes.funbox.novate.databinding.ContentItemLayoutBinding
import com.susyimes.funbox.novate.model.Content


class ContentAdapter(private val context: Context) : BaseDiffAdapter(DiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NoteItemHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.content_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NoteItemHolder){
            holder.bind(getItem(position) as Content)
        }
    }

    class NoteItemHolder(private val binding: ContentItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Content){
            //binding.viewmodel = viewModel
            binding.data = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): NoteItemHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ContentItemLayoutBinding.inflate(layoutInflater, parent, false)
                return NoteItemHolder(binding)
            }
        }

    }

    private class DiffCallback : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
            return if (oldItem is Content && newItem is Content) {
                oldItem.hashCode() == newItem.hashCode()
            } else {
                false
            }
        }
        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
            return if (oldItem is Content && newItem is Content) {
                oldItem.content == newItem.content
            } else {
                false
            }
        }
    }
}