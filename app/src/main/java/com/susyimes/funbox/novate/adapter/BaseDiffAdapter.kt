package com.susyimes.funbox.novate.adapter


import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


abstract class BaseDiffAdapter(diffUtil: DiffUtil.ItemCallback<Any>) : ListAdapter<Any, RecyclerView.ViewHolder>(diffUtil) {

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    abstract override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)

}