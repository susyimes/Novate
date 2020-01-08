package com.susyimes.funbox.novate.common

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import com.susyimes.funbox.novate.R


/**
 * Created by susyimes on 2019/8/19.
 */

class LoadingDialog(context: Context, private val str: String) : Dialog(context, R.style.loading_dialog) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.loading_layout)
        findViewById<TextView>(R.id.loading_text).text = str
        setCanceledOnTouchOutside(false)

    }


}
