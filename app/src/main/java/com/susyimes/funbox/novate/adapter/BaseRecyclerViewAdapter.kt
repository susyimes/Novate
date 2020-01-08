package com.susyimes.funbox.novate.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    abstract override fun onCreateViewHolder(vp: ViewGroup, pos: Int): RecyclerView.ViewHolder

    abstract override fun getItemCount(): Int

    abstract override fun onBindViewHolder(vh: RecyclerView.ViewHolder, pos: Int)

}