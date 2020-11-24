package com.susyimes.funbox.novate.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.susyimes.funbox.novate.R


abstract class BaseAutoRecyclerViewAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>(), AutoUpdatableAdapter {

    var mListData = emptyList<T>()
    private var oldListData = emptyList<T>()
    val listCallback by lazy { ListCallback() }

    open fun setList(items: List<T>?) {
        if (items != null) {
            this.mListData = items

            autoNotify(listCallback, ArrayList(oldListData), ArrayList(items)) { o, n ->

                    o === n

            }

            oldListData = items
        }
    }

    abstract override fun onCreateViewHolder(vp: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    abstract override fun getItemCount(): Int

    abstract override fun onBindViewHolder(vh: RecyclerView.ViewHolder, pos: Int)

    class TestViewHolder(context: Context?, vp:ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(
        R.layout.item_loading,vp,false))

//    class ItemViewHolder private constructor(private val binding: PaymentGoodsItemBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(model: PaymentModel.Item, viewModel: PaymentCenterVM) {
//            binding.viewmodel = viewModel
//            binding.data = model
//            binding.executePendingBindings()
//        }
//
//        companion object {
//            fun from(parent: ViewGroup): ItemViewHolder {
//                val layoutInflater = LayoutInflater.from(parent.context)
//                val binding = PaymentGoodsItemBinding.inflate(layoutInflater, parent, false)
//                binding.discountPrice.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG
//                return ItemViewHolder(binding)
//            }
//        }
//    }
}