package com.susyimes.funbox.novate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.susyimes.funbox.novate.R
import com.susyimes.funbox.novate.databinding.NoteItemLayoutBinding
import com.susyimes.funbox.novate.model.Note


class NoteAdapter(private val context:Context) : BaseDiffAdapter(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NoteItemHolder(DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.note_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       if (holder is NoteItemHolder){
           holder.bind(getItem(position) as Note)
       }
    }

    class NoteItemHolder(private val binding: NoteItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Note){
            //binding.viewmodel = viewModel
            binding.data = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): NoteItemHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = NoteItemLayoutBinding.inflate(layoutInflater, parent, false)
                return NoteItemHolder(binding)
            }
        }

    }

    private class DiffCallback : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
            return if (oldItem is Note && newItem is Note) {
                oldItem.hashCode() == newItem.hashCode()
            } else {
                false
            }
        }
        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
            return if (oldItem is Note && newItem is Note) {
                oldItem.title == newItem.title
            } else {
                false
            }
        }
    }
}