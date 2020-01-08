package com.susyimes.funbox.novate.bindings


import android.graphics.Bitmap
import android.widget.ImageView

import androidx.databinding.BindingAdapter

import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.susyimes.funbox.novate.R
import com.susyimes.funbox.novate.utils.DisplayUtil.dp2px

import jp.wasabeef.glide.transformations.RoundedCornersTransformation


/**
 * Created by susyimes on 2017/7/20.
 */

object ImageViewDataBinding {
    private val TAG = "ImageViewDataBinding"

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: Any) {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }

    @BindingAdapter("imageUrlCrop")
    @JvmStatic
    fun loadImageCrop(imageView: ImageView, url: Any) {
        Glide.with(imageView.context)
            .load(url)
            .centerCrop()
            .into(imageView)
    }


    /**
     * 圆角和centerCrop
     * @param imageView
     * @param url
     * @param cornerRadius
     */
    @BindingAdapter(value = ["imageUrl", "cornerRadius"])
    @JvmStatic
    fun loadCenterCropCornerRadiusImage(imageView: ImageView, url: Any, cornerRadius: Int) {

        val multi = MultiTransformation<Bitmap>(
            CenterCrop(),
            RoundedCornersTransformation(
                dp2px(imageView.context, cornerRadius.toFloat()).toInt(),
                0,
                RoundedCornersTransformation.CornerType.ALL
            )
        )
        Glide.with(imageView.context)
            .load(url)
            .placeholder(R.drawable.gray_bg)
            .apply(RequestOptions.bitmapTransform(multi))
            .into(imageView)
    }


    @BindingAdapter("circleImageUrl")
    @JvmStatic
    fun loadCircleImage(imageView: ImageView, url: Any) {

        Glide.with(imageView.context.applicationContext)
            .load(url)
            .apply(RequestOptions.priorityOf(Priority.HIGH))//小圆头像更新慢
            .apply(RequestOptions.circleCropTransform())
            .into(imageView)

    }


}
