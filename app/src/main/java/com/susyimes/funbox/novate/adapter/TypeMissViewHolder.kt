package com.susyimes.funbox.novate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.susyimes.funbox.novate.BuildConfig
import com.susyimes.funbox.novate.R

/**
 * Created by susyimes
 * on 2020/6/10.
 */

class TypeMissViewHolder(context: Context?, vp: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(
    R.layout.item_type_missing, vp, false)) {
    init {
        if (!BuildConfig.DEBUG) {
            itemView.layoutParams.height = 0
            itemView.visibility = View.GONE
        }
    }
}