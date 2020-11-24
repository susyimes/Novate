package com.susyimes.funbox.novate

import android.content.Intent
import android.os.Bundle
import com.leinardi.android.speeddial.SpeedDialView
import com.susyimes.funbox.novate.base.BaseActivity
import com.susyimes.funbox.novate.view.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        speedDial.setOnChangeListener(object : SpeedDialView.OnChangeListener {
            override fun onMainActionSelected(): Boolean {
                startActivity(Intent(this@MainActivity,DetailActivity::class.java))
                return true // True to keep the Speed Dial open
            }

            override fun onToggleChanged(isOpen: Boolean) {

            }
        })
    }


}
