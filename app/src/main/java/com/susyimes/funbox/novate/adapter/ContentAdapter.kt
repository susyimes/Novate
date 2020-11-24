package com.susyimes.funbox.novate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.susyimes.funbox.novate.databinding.ContentItemLayoutBinding
import com.susyimes.funbox.novate.model.Content


class ContentAdapter(private val context: Context) : BaseAutoRecyclerViewAdapter<Content>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NoteItemHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NoteItemHolder){
            holder.bind(mListData[position])
        }
    }

    class NoteItemHolder(private val binding: ContentItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Content){
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
    override fun getItemCount(): Int {
      return  mListData.size
    }
}