package com.js.soundmeter.ui.home

import android.content.Intent
import android.os.Bundle
import com.js.soundmeter.R
import com.js.soundmeter.ui.base.BaseFragmentActivity
import com.js.soundmeter.ui.noise.MeasureNoiseActivity
import com.js.soundmeter.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseFragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_noise.setOnClickListener { toMeasureNoise() }
        bt_voice.setOnClickListener { toMeasureFrequency() }

    }

    // 测量分贝
    private fun toMeasureNoise() {
        val intent = Intent(this, MeasureNoiseActivity::class.java)
        startActivity(intent)
    }

    // 测量赫兹
    private fun toMeasureFrequency() {
//        val intent = Intent(this, DetectionActivity::class.java)
//        startActivity(intent)
        ToastUtil.showMessage(mContext, "正在开发，敬请期待")
    }

//    退出程序
    private var exitTime: Long = 0
    override fun onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            ToastUtil.showMessage(mContext, "再按一次退出程序")
            exitTime = System.currentTimeMillis()
        } else {
            finish()
        }
    }
}
