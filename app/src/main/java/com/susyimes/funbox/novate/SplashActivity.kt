package com.susyimes.funbox.novate

import android.content.Intent
import android.os.Bundle
import com.susyimes.funbox.novate.base.BaseActivity
import com.susyimes.funbox.novate.ext.addTo
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Observable.timer(1,TimeUnit.SECONDS).subscribe {
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
            finish()
        }.addTo(compositeDisposable)

    }
}
