package com.susyimes.funbox.novate.bindings

import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter



/**
 * Created by susyimes on 2019/5/29.
 */


@BindingAdapter("textbackground")
fun textViewBackground(view: TextView, id: Int) {
    view.setBackgroundResource(id)
}
@BindingAdapter("textviewcolor")
fun textViewColor(view: TextView, colorstr: Any) {
    if (colorstr is String) {
        view.setTextColor(Color.parseColor(colorstr))
    }
}



