package com.susyimes.funbox.novate.ext


import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


internal infix fun SwitchCompat.onCheckedChanged(function: (CompoundButton, Boolean) -> Unit) {
    setOnCheckedChangeListener(function)
}

internal infix fun View.onClick(function: () -> Unit) {
    setOnClickListener { function() }
}

fun View.isVisible(): Boolean = visibility == View.VISIBLE
fun View.setVisible(isShow: Boolean) {
    visibility = if (isShow) View.VISIBLE else View.GONE
}

fun View.setupToast(
    lifecycleOwner: LifecycleOwner,
    toastEvent: LiveData<Event<Int>>
) {
    toastEvent.observe(lifecycleOwner, Observer { event ->
        event?.getContentIfNotHandled()?.let {
            Toast.makeText(context,context.getString(it) as String,Toast.LENGTH_SHORT).show()
        }
    })
}
fun View.setupRouter(
        lifecycleOwner: LifecycleOwner,
        clickEvent: LiveData<Event<String>>
){
    clickEvent.observe(lifecycleOwner, Observer { event ->
        event?.getContentIfNotHandled()?.let {
            //ClickRouter(context).ClickUri(it)
        }
    })
}

/***
 * 设置延迟时间的View扩展
 * @param delay Long 延迟时间，默认600毫秒
 * @return T
 */
fun <T : View> T.withTrigger(delay: Long = 600): T {
    triggerDelay = delay
    return this
}

/***
 * 点击事件的View扩展
 * @param block: (T) -> Unit 函数
 * @return Unit
 */
fun <T : View> T.click(block: (T) -> Unit) = setOnClickListener {
    block(it as T)
}

/***
 * 带延迟过滤的点击事件View扩展
 * @param delay Long 延迟时间，默认600毫秒
 * @param block: (T) -> Unit 函数
 * @return Unit
 */
fun <T : View> T.clickWithTrigger(time: Long = 600, block: (T) -> Unit){
    triggerDelay = time
    setOnClickListener {
        if (clickEnable()) {
            block(it as T)
        }
    }
}

private var <T : View> T.triggerLastTime: Long
    get() = if (getTag(234565432) != null) getTag(234565432) as Long else -601
    set(value) {
        setTag(234565432, value)
    }

private var <T : View> T.triggerDelay: Long
    get() = if (getTag(123454321) != null) getTag(123454321) as Long else 600
    set(value) {
        setTag(123454321, value)
    }

private fun <T : View> T.clickEnable(): Boolean {
    var flag = false
    val currentClickTime = System.currentTimeMillis()
    if (currentClickTime - triggerLastTime >= triggerDelay) {
        flag = true
    }
    triggerLastTime = currentClickTime
    return flag
}

/***
 * 带延迟过滤的点击事件监听，见[View.OnClickListener]
 * 延迟时间根据triggerDelay获取：600毫秒，不能动态设置
 */
interface OnLazyClickListener : View.OnClickListener {

    override fun onClick(v: View?) {
        if (v?.clickEnable() == true) {
            onLazyClick(v)
        }
    }

    fun onLazyClick(v: View)
}

