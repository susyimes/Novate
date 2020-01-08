package com.susyimes.funbox.novate.common

import android.content.Context

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.susyimes.funbox.novate.R


class LoadingViewHolder(context: Context?,vp:ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(
    R.layout.item_loading,vp,false))
