package com.susyimes.funbox.novate.view


import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.susyimes.funbox.novate.base.BaseActivity
import com.susyimes.funbox.novate.R
import com.susyimes.funbox.novate.adapter.ContentAdapter
import com.susyimes.funbox.novate.databinding.ActivityDetailBinding
import com.susyimes.funbox.novate.viewmodel.DetailVM
import kotlinx.android.synthetic.main.activity_detail.*
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ItemTouchHelper



class DetailActivity : BaseActivity() {
    private val detailVM by lazy { ViewModelProviders.of(this)[DetailVM::class.java] }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
        initActionBar("详情页")

        binding.viewmodel = detailVM
        binding.setLifecycleOwner { this.lifecycle }
        initView()
        detailVM.loadData()
    }

    private fun initView() {
        contents_list.layoutManager = LinearLayoutManager(this)
        val contentAdapter = ContentAdapter(this)
        contents_list.adapter = contentAdapter

        val mIth = ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP or ItemTouchHelper.DOWN,
                ItemTouchHelper.LEFT
            ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: ViewHolder, target: ViewHolder
                ): Boolean {
                    val fromPos = viewHolder.adapterPosition
                    val toPos = target.adapterPosition
                    // move item in `fromPos` to `toPos` in adapter.
                    contentAdapter.notifyItemMoved(fromPos,toPos)

                    return true// true if moved, false otherwise
                }

                override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
                    // remove from adapter
                    detailVM.removeData(viewHolder.adapterPosition)
                    contentAdapter.notifyItemRemoved(viewHolder.adapterPosition)
                }
            })

        mIth.attachToRecyclerView(contents_list)

    }

}
