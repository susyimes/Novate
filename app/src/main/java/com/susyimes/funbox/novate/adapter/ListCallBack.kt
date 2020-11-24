package com.susyimes.funbox.novate.adapter


import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListUpdateCallback


/**
 * Created by susyimes
 * on 2020/5/14.
 */

class ListCallback : ListUpdateCallback {

    var realposition = 0
    lateinit var adapter: RecyclerView.Adapter<*>
    fun bind(adapter: RecyclerView.Adapter<*>) {
        if (!this::adapter.isInitialized) {
            this.adapter = adapter
        }
    }

    override fun onChanged(position: Int, count: Int, payload: Any?) {
        adapter.notifyItemRangeChanged(position, count, payload)
    }

    override fun onInserted(position: Int, count: Int) {
        adapter.notifyItemRangeInserted(realposition, count)
    }

    override fun onMoved(fromPosition: Int, toPosition: Int) {
        adapter.notifyItemMoved(fromPosition, toPosition)
    }

    override fun onRemoved(position: Int, count: Int) {
        adapter.notifyItemRangeRemoved(position, count)
    }

    fun setRealInsertPosition(realposition: Int) {
        this.realposition = realposition
    }
}