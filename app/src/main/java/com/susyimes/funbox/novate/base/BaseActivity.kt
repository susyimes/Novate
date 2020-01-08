package com.susyimes.funbox.novate.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.gyf.immersionbar.ImmersionBar
import com.susyimes.funbox.novate.R
import io.reactivex.disposables.CompositeDisposable

open class BaseActivity : AppCompatActivity() {

    val compositeDisposable by lazy { CompositeDisposable() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ImmersionBar.with(this).statusBarDarkFont(true).init()
    }

    fun initActionBar(title: String) {
        findViewById<ImageView>(R.id.back).setOnClickListener {
            finish()
        }
        findViewById<TextView>(R.id.title).text = title
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

}
