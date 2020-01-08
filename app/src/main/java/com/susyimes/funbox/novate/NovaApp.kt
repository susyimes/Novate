package com.susyimes.funbox.novate

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex


class NovaApp :Application(){
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}