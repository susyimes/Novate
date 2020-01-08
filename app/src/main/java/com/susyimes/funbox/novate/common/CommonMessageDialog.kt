package com.susyimes.funbox.novate.common


import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import com.susyimes.funbox.novate.R
import com.susyimes.funbox.novate.ext.onClick
import com.susyimes.funbox.novate.ext.setVisible
import kotlinx.android.synthetic.main.common_message_dialog.*

/**
 * Created by susyimes on 2019/8/19.
 */

class CommonMessageDialog(context: Context, private val str: String) : Dialog(context, R.style.common_dialog) {


    internal var listener: ConfirmLinstener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val window = this.window
        window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)//设置横向全屏
        setContentView(R.layout.common_message_dialog)
        title.text = str
        confirm onClick {
            listener?.onConfirm()
            dismiss()
        }
        cancel onClick {
            listener?.onCancel()
            dismiss() }
    }

    fun setConfirmText(str:String){
        if (this.isShowing) {
            confirm.text = str
        }
    }

    fun setCancelButtonVisible(vis:Boolean){
        if (this.isShowing) {
            cancel.setVisible(vis)
            mid_line.setVisible(vis)
        }
    }


    interface ConfirmLinstener {
        fun onConfirm()
        fun onCancel()
    }


    fun setOnConfirmLinstener(listener: ConfirmLinstener) {
        this.listener = listener
    }
}
