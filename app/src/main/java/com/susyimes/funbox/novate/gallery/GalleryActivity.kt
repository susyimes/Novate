package com.susyimes.funbox.novate.gallery

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.github.chrisbanes.photoview.PhotoView
import com.gyf.immersionbar.ImmersionBar
import com.susyimes.funbox.novate.NoteConstants
import com.susyimes.funbox.novate.R

import kotlinx.android.synthetic.main.activity_gallery.*



class GalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        ImmersionBar.with(this).init()
        val dataList = intent.getSerializableExtra(NoteConstants.DATA_LIST) as ArrayList<String>
        viewpager.adapter = GalleryAdapter(dataList)
        pageNum.text = 1.toString() + "/" + dataList.size


        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                pageNum.text = (position + 1).toString() + "/" + dataList.size

            }
        })
    }

    inner class GalleryAdapter(private val dataList: ArrayList<String>) : BasePagerAdapter<Any>() {
        override fun onCreateViewHolder(context: Context?, position: Int): PagerHolder<Any> {
            val frameLayout = FrameLayout(baseContext)
            return PagerHolder(frameLayout)
        }

        override fun onBindViewHolder(context: Context?, holder: PagerHolder<Any>?) {
            val frame = holder?.itemView as FrameLayout
            val inflate = LayoutInflater.from(baseContext).inflate(R.layout.photo_item_layout, null)
            val photoView = inflate.findViewById<PhotoView>(R.id.photo)
            Glide.with(baseContext).load(dataList[holder.itemPosition]).into(photoView)

            frame.addView(inflate)
        }

        override fun isViewHolderChanged(holder: PagerHolder<Any>?): Boolean {
            return true
        }

        override fun getCount(): Int {
            return dataList.size
        }


    }

}
